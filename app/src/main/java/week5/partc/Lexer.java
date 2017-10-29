package week5.partc;

import java.util.ArrayList;

/**
 * Calculator lexical analyzer.
 */
public class Lexer {

    private ArrayList<Token> tokens = new ArrayList<>();

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    /**
     * Token in the stream.
     */
    public static class Token {
        final Type type;
        final String text;

        Token(Type type, String text) {
            this.type = type;
            this.text = text;
        }

        Token(Type type) {
            this(type, null);
        }

        /*
            Checks whether the type is an numeric operation.
            @return a boolean check
         */
        public boolean isOperation(){
            return type == Type.DIVIDE || type == Type.TIMES || type == Type.PLUS || type == Type.MINUS;
        }

        public boolean isUnit(){
            return type == Type.INCH || type == Type.POINT;
        }

        @Override
        public String toString() {
            return type + " : " + text;
        }
    }

    public class TokenMismatchException extends Exception {
        public TokenMismatchException(String message){
            super(message);
        }
    }

    /*
        Creates the Lexer with the input equation.
        Does not do any validation on the syntax.

        @param  input   the equation to be lexically analyzed
     */
    public Lexer(String input) {
        // split before and after all operations.
        String[] tokens = input.replaceAll("\\s+", "").split("(?<=[-+*/()])|(?=[-+*/()])|(?=(pt|in))|(?<=(pt|in))");
        try {
            Type type;
            String value;
            for (String token : tokens) {
                value = null;
                type = null;
                switch (token) {
                    case "(":
                        type = Type.L_PAREN;
                        break;
                    case ")":
                        type = Type.R_PAREN;
                        break;
                    case "+":
                        type = Type.PLUS;
                        break;
                    case "-":
                        type = Type.MINUS;
                        break;
                    case "*":
                        type = Type.TIMES;
                        break;
                    case "/":
                        type = Type.DIVIDE;
                        break;
                    default:
                        // it is a number
                        if (token.matches("-?\\d+[.]?\\d*")) {
                            type = Type.NUMBER;
                            value = token;
                        }
                        else if (token.endsWith("pt"))
                            type = Type.POINT;
                        else if (token.endsWith("in"))
                            type = Type.INCH;
                        else
                            throw new TokenMismatchException(String.format("Unknown operator for %s", token));
                        break;
                }
                this.tokens.add(value == null ? new Token(type) : new Token(type, value));
            }
        } catch (TokenMismatchException e) {
            System.out.println(e);
        }
    }

}
