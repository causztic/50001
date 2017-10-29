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
}