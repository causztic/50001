package week5.partc;

/*
 * TODO (optional) define your grammar here
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
			operations.add(Type.PLUS); // always add the first value.
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
			System.out.println("Tokens: " + tokens);
			Value result = new Value(0.0, ValueType.SCALAR);

			// create Value and Operation objects
			for (int i = 0; i < tokens.size(); i++){
				if (tokens.get(i) == null){
					values.add(children.remove(0).evaluate());
				} else if (tokens.get(i).type == Type.NUMBER){
					if (i+1 < tokens.size() && tokens.get(i+1).isUnit()){
						values.add(new Value(Double.parseDouble(tokens.get(i).text), evalValueType(tokens.get(i+1).type)));
						i++; // advance pointer past the unit.
					} else {
						// unitless
						values.add(new Value(Double.parseDouble(tokens.get(i).text), ValueType.SCALAR));
					}
				} else if (tokens.get(i).isOperation()){
					// it is an operation
					operations.add(tokens.get(i).type);
				}
			}

			System.out.println(operations + " " + values);

//			if (values.size() > 2)
//				throw new ParserException("Order of operations not made explicit.");

			// actual evaluation
			for (int i = 0; i < operations.size(); i++){
				result = result.operate(values.get(i), operations.get(i));
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
			switch (operation){
				case PLUS:
					return new Value(this.value + value.value, ValueType.SCALAR);
				case MINUS:
					return new Value(this.value - value.value, ValueType.SCALAR);
				case TIMES:
					return new Value(this.value * value.value, ValueType.SCALAR);
				case DIVIDE:
					if (value.value == 0)
						throw new ParserException("Division by zero.");
					return new Value(this.value / value.value, ValueType.SCALAR);
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
					if (prevState == State.IS_OPERATION)
						throw new ParserException("Cannot have an operation after an operation.");
					if (prevState == State.IS_L_PAREN)
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
					equation.tokens.add(token);
					if (prevState == State.IS_UNIT)
						throw new ParserException("Cannot have a unit after a unit.");
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
		} else if (token.isOperation()){
			state = State.IS_OPERATION;
		} else if (token.isUnit()){
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
