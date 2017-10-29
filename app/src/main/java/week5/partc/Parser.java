package week5.partc;

/*
 * The calculator is able to handle the standard arithmetic methods of prioritizing
 * Brackets first by recursion,
 * then multiplication and division,
 * then normal addition and subtraction.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Calculator parser. All values are measured in pt.
 */
class Parser {

	/*
		Equation class to evaluate equations.
		Can consist of more Equations as children.
		The main equation will then be evaluated recursively.
	 */

	class Equation {
		List<Lexer.Token> tokens = new ArrayList<>();
		List<Equation> children = new ArrayList<>();

		private List<Value> values = new ArrayList<>();
		private List<Type> operations = new ArrayList<>();

		Equation parent;

		Equation(){
			parent = null;
			operations.add(Type.START); // the first operation is always START to copy the first number in as-is.
		}

		Equation(List<Lexer.Token> tokens){
			this();
			this.tokens = tokens;
		}


		void setParent(Equation parent){
			this.parent = parent;
			this.parent.addChildren(this);
		}

		void addChildren(Equation eqn){
			children.add(eqn);
		}

		private ValueType evalValueType(Type type){
			switch (type){
				case POINT:
					return ValueType.POINTS;
				case INCH:
					return ValueType.INCHES;
				default:
					return ValueType.SCALAR;
			}
		}

		// Recursively evaluate the equation and their subsequent sub-equations.
		Value evaluate(){
			Value result = new Value(0.0, ValueType.SCALAR);

			// create Value and Operation objects
			for (int i = 0; i < tokens.size(); i++){
				if (tokens.get(i) == null){
					values.add(children.remove(0).evaluate());
				}
				else if (tokens.get(i).type == Type.MINUS){
					if (i + 1 < tokens.size() && tokens.get(i+1) == null) {
						operations.add(Type.MINUS);
						// it is a negative but followed by a sub equation, continue
						continue;
					}

					// it is a minus sign, set the value to be negative
					if (i != 0 && !tokens.get(i-1).type.isOperation()){
						// if the one before is not an operation, set it to plus.
						operations.add(Type.PLUS);
					}

					if (i + 1 < tokens.size() && tokens.get(i+1).type == Type.NUMBER){
						double temp = Double.parseDouble(tokens.get(i+1).text) * -1;
						i++;
						if (i + 2 < tokens.size() && tokens.get(i+2).type.isUnit()){
							// if there is a unit for the negative number
							// multiply by a constant if it is in inches to store as points.
							values.add(new Value(temp * ( tokens.get(i+2).type == Type.INCH ? PT_PER_IN : 1), evalValueType(tokens.get(i+2).type)));
							i++;
						} else {
							//unitless
							values.add(new Value(temp, ValueType.SCALAR));
						}
					}
				}
				else if (tokens.get(i).type == Type.NUMBER){
					// it is a number and has a unit.
					if (i+1 < tokens.size() && tokens.get(i+1).type.isUnit()){
						values.add(new Value(Double.parseDouble(tokens.get(i).text) * (tokens.get(i+1).type == Type.INCH ? PT_PER_IN : 1), evalValueType(tokens.get(i+1).type)));
						i++; // advance pointer past the unit.
					} else {
						// unitless
						values.add(new Value(Double.parseDouble(tokens.get(i).text), ValueType.SCALAR));
					}
				} else if (tokens.get(i).type.isOperation()){
					// it is an operation
					operations.add(tokens.get(i).type);
				}
			}

			System.out.println(operations + " " + values);

//			if (values.size() > 2)
//				throw new ParserException("Order of operations not made explicit.");

			// actual evaluation
			int priorityCount = 0;

			// count the number of priority operations to do first. (division and multiplication.)
			for (Type operation: operations){
				if (operation.isPriority())
					priorityCount++;
			}

			while (priorityCount != 0) {
				for (int i = 0; i < operations.size(); i++) {
					// look for multiplication and division first. instead of using the result,
					// we modify the values directly to be used by the normal operations.
					// this is to preserve the order.
					if (operations.get(i).isPriority()) {
						values.set(i-1, values.get(i-1).operate(values.get(i), operations.remove(i)));
						values.remove(i);
						priorityCount--;
					}
				}
			}

			// handle the other operations.
			for (int i = 0; i < operations.size(); i++) {
				if (values.size() > i)
					result = result.operate(values.get(i), operations.get(i));
				else
					result = result.operate(null, operations.get(i));
			}

			return result;
		}
	}

	@SuppressWarnings("serial")
	static class ParserException extends RuntimeException {
		public ParserException(String message){
			super(message);
		}
	}


	/**
	 * Type of values.
	 */
	private enum ValueType {
		POINTS, INCHES, SCALAR
	};

	/**
	 * Internal value is always in points.
	 */
	public class Value {
		final double value;
		final ValueType type;

		Value(double value, ValueType type) {
			this.value = value;
			this.type = type;
		}

		public Value operate(Value value, Type operation){
			ValueType type = ValueType.SCALAR;
			switch (operation){
				case PLUS:
					if (this.type == ValueType.SCALAR && value.type == ValueType.INCHES) // as per manual
						type = ValueType.INCHES;
					else
						type = this.type;
					System.out.println(this.value + " " + value + " " + type);
					return new Value(this.value + value.value, type);
				case MINUS:
					return new Value(this.value - value.value, type);
				case TIMES:
					// inches * scalar = inches
					// scalar * points = points
					// inches * points = points
					if (this.type == ValueType.INCHES || value.type == ValueType.INCHES)
						type = ValueType.INCHES;
					if (this.type == ValueType.POINTS || value.type == ValueType.POINTS)
						type = ValueType.POINTS;

					return new Value(this.value * value.value, type);

				case DIVIDE:
					if (value.value == 0)
						throw new ParserException("Division by zero.");

					// scalar / inches = inches
					// scalar / points = points
					// inches / points AND points / inches = scalar
					if (this.type == ValueType.SCALAR)
						type = value.type;
					else if (this.type == ValueType.INCHES || this.type == ValueType.POINTS)
						if (value.type == ValueType.SCALAR) // maintain the units
							type = this.type;

					return new Value(this.value / value.value, this.type);
				case CAST_TO_INCH:
					return new Value(this.value, ValueType.INCHES);
				case CAST_TO_POINT:
					return new Value(this.value, ValueType.POINTS);
				case START:
					return new Value(value.value, value.type);
				default:
					throw new ParserException("Unreachable.");
			}
		}

		@Override
		public String toString() {
			switch (type) {
			case INCHES:
				return value / PT_PER_IN + " in";
			case POINTS:
				return value + " pt";
			default:
				return "" + value;
			}
		}
	}

	private static final double PT_PER_IN = 72;
	private final Lexer lexer;
	private State state = State.INITIAL;
	private State prevState = State.INITIAL;

	private int lParenCount = 0;
	private int rParenCount = 0;
	private Equation equation;

	private enum State {
		INITIAL, IS_L_PAREN, IS_R_PAREN, IS_NUMBER, IS_OPERATION, IS_UNIT
	}


	/*
		Takes in the Lexer to analyse the tokens obtained.
		We are assuming every operation to be bound by parenthesis.
		Performs syntax validation before it evaluates.

		@params	lexer	The Lexer to use.
	 */
	Parser(Lexer lexer) {
		this.lexer = lexer;
		Double currentValue = null;
		Lexer.Token first = this.lexer.getTokens().get(0);
		equation = new Equation();

		// check first token
		setStateWithToken(first);
		if (state == State.IS_OPERATION || state == State.IS_UNIT || state == State.IS_R_PAREN)
			throw new ParserException("Cannot start an equation with an operation, a unit, or a right parenthesis.");

		if (first.type == Type.L_PAREN){
			// is a L_PAREN, create a sub equation.
			equation.tokens.add(null); // add a null placer to indicate a child
			Equation e = new Equation();
			e.setParent(equation);
			equation = e;
		} else {
			equation.tokens.add(first);
		}


		for (Lexer.Token token: this.lexer.getTokens().subList(1, this.lexer.getTokens().size())) {
			setStateWithToken(token);
			switch (state){
				case IS_OPERATION:
					equation.tokens.add(token);
					// if it is an operation, it should not be a unit nor an operation after.
					if (prevState == State.IS_OPERATION && token.type != Type.MINUS)
						throw new ParserException("Cannot have an operation after an operation.");
					if (prevState == State.IS_L_PAREN && token.type != Type.MINUS)
						throw new ParserException("Invalid Left parenthesis before operator.");
					break;
				case IS_L_PAREN:
					// Create a subequation.
					equation.tokens.add(null); // add a null placer to indicate a child
					Equation e = new Equation();
					e.setParent(equation);
					equation = e;
					if (prevState == State.IS_NUMBER)
						throw new ParserException("No implicit multiplication with parenthesis allowed.");
					break;
				case IS_UNIT:
					if (prevState == State.IS_NUMBER)
						equation.tokens.add(token);
					// if it not a number before a unit, it is a casting.
					else if (token.type == Type.INCH)
						equation.tokens.add(new Lexer.Token(Type.CAST_TO_INCH));
					else if (token.type == Type.POINT)
						equation.tokens.add(new Lexer.Token(Type.CAST_TO_POINT));

					// check for invalids
					if (prevState == State.IS_OPERATION)
						throw new ParserException("Cannot have an operation before a unit.");
					break;
				case IS_R_PAREN:
					// close a subequation, go back up one level.
					equation = equation.parent;
					if (prevState == State.IS_OPERATION)
						throw new ParserException("Invalid syntax. The operation before the right parenthesis has no operand.");
					if (prevState == State.IS_L_PAREN)
						throw new ParserException("No empty parenthesis body allowed.");
					break;
				case IS_NUMBER:
					equation.tokens.add(token);
					if (prevState == State.IS_R_PAREN)
						throw new ParserException("No implicit multiplication with parenthesis allowed.");
					if (prevState == State.IS_UNIT)
						throw new ParserException("Casting should be done after a number, not before.");
					break;
				default:
					break;
			}
		}

		if (lParenCount != rParenCount)
			throw new ParserException("The number of left parenthesis vs the right parenthesis do not match.");
	}

	/*
		Sets the parser state based on the token.
	 */
	private void setStateWithToken(Lexer.Token token){
		prevState = state;
		if (token.type == Type.L_PAREN){
			lParenCount++;
			state = State.IS_L_PAREN;
		} else if (token.type == Type.R_PAREN){
			rParenCount++;
			state = State.IS_R_PAREN;
		} else if (token.type == Type.NUMBER){
			state = State.IS_NUMBER;
		} else if (token.type.isOperation()){
			state = State.IS_OPERATION;
		} else if (token.type.isUnit()){
			state = State.IS_UNIT;
		}
	}

	/*
		Evaluates the equations generated by the Parser.
	 */
	public Value evaluate() {
		Value result = equation.evaluate();
		return result;
	}
}
