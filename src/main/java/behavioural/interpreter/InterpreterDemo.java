package behavioural.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*  Interpreter - a component that processes structured text data. Does so by turning it into
        separate lexical tokens (lexing) and then interpreting sequences of said tokens (parsing).
**/
// check 'ANTLR' for these already built-in interpreting tools/patterns

// lexing related classes
class Tokens {
    public enum Type {
        INTEGER,
        PLUS,
        MINUS,
        LPAREN,
        RPAREN
    }

    public Type type;
    public String text;

    public Tokens(Type type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        return "`" + text + "`";
    }
}

// parsing related classes
interface Element {
    int eval();
}

class Integer implements Element {
    private int value;

    public Integer(int val) {
        value = val;
    }

    @Override
    public int eval() {
        return value;
    }
}

class BinaryOperation implements Element {
    enum Type {
        ADDITION,
        SUBTRACTION
    }

    public Type type;
    public Element left, right;

    @Override
    public int eval() {
        switch (type) {
            case ADDITION:
                return left.eval() + right.eval();
            case SUBTRACTION:
                return left.eval() - right.eval();
            default:
                return 0;
        }
    }
}

public class InterpreterDemo {
    static List<Tokens> lex(String input) {
        // first convert input string to a list of tokens to identify and map every character
        List<Tokens> list = new ArrayList<>();
        for(int i = 0; i< input.length(); ++i) {
            switch(input.charAt(i)) {
                case '+':
                    list.add(new Tokens(Tokens.Type.PLUS, "+"));
                    break;
                case '-':
                    list.add(new Tokens(Tokens.Type.MINUS, "-"));
                    break;
                case '(':
                    list.add(new Tokens(Tokens.Type.LPAREN, "("));
                    break;
                case ')':
                    list.add(new Tokens(Tokens.Type.RPAREN, ")"));
                    break;
                default:
                    // in case of an integer read the full number until another expression appears like + - ( or )
                    StringBuilder sb = new StringBuilder("" + input.charAt(i));
                    for (int j = i+1; j < input.length(); ++j) {
                        if (Character.isDigit(input.charAt(j))) {
                            sb.append(input.charAt(j));
                            ++i;
                        } else {
                            list.add(new Tokens(Tokens.Type.INTEGER, sb.toString()));
                            break;
                        }
                    }
                    break;
            }
        }
        return list;
    }

    static Element parse(List<Tokens> tokens) {
        // secondly parse the tokens and calculate the result of each sub-expression
        BinaryOperation result = new BinaryOperation();
        // flag to define whether left expression has been +evaluated or not
        boolean haveLHS = false;

        for (int i = 0; i < tokens.size(); ++i) {
            Tokens token = tokens.get(i);

            switch(token.type) {
                case INTEGER:
                    Integer intg = new Integer(java.lang.Integer.parseInt(token.text));
                    if (!haveLHS) {
                        result.left = intg;
                        haveLHS = true;
                    } else result.right = intg;
                    break;
                case PLUS:
                    result.type = BinaryOperation.Type.ADDITION;
                    break;
                case MINUS:
                    result.type = BinaryOperation.Type.SUBTRACTION;
                    break;
                case LPAREN:
                    int j = 0; // location of rparen
                    for (; j < tokens.size(); ++j)
                        if (tokens.get(j).type == Tokens.Type.RPAREN)
                            break;
                    List<Tokens> subexpression = tokens.stream()
                            .skip(i + 1)
                            .limit(j - i - 1)
                            .collect(Collectors.toList());
                    Element element = parse(subexpression);
                    if (!haveLHS) {
                        result.left = element;
                        haveLHS = true;
                    } else {
                        result.right = element;
                    }
                    i = j;
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // lexing operation
        String input = "(13+4)-(12+1)";
        List<Tokens> tokens = lex(input);
        System.out.println(tokens.stream()
            .map(t -> t.toString())
            .collect(Collectors.joining("\t")));

        // parsing operation
        Element parsed = parse(tokens);
        System.out.println(input + " = " + parsed.eval());
    }
}
