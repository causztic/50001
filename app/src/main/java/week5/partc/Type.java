package week5.partc;

/*
 * The lexer will only be in charge of setting types.
 * All logic will be done in the Parser.
 *
 * L_PAREN and R_PAREN are groups. They define a sub-equation.
 *
 * INCH and POINT are units.
 *
 * PLUS, MINUS, TIMES, DIVIDE are operations.
 */

/**
 * Token type.
 */
enum Type {
	L_PAREN,	// it means (
	R_PAREN,	// it means )
	NUMBER,		// 1, 2, 3, 4...
	INCH,		// should only occur after a number
	POINT,		// should only occur after a number
	PLUS,		// +
	MINUS,		// -
	TIMES,		// *
	DIVIDE,		// /
	START,		// Used in the parser to start an equation. Copies the first item as-is.
	CAST_TO_INCH, // Used in the parser to denote casting.
	CAST_TO_POINT; // Used in the parser to denote casting.

	public boolean isPriority(){
		return this == DIVIDE || this == TIMES;
	}

	public boolean isOperation(){
		return isPriority() || this == PLUS || this == MINUS || this == CAST_TO_INCH || this == CAST_TO_POINT;
	}

	public boolean isUnit(){
		return this == INCH || this == POINT;
	}

}