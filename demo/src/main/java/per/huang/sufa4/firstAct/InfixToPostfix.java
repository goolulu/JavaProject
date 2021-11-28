package per.huang.sufa4.firstAct;

import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.util.Stack;

public class InfixToPostfix {
    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char MUL = '*';
    private static final char DIV = '/';
    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';

    public String transform(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ADD) {
                stack.push(ADD);
            } else if (c == SUB) {

                stack.push(SUB);

            } else if (c == MUL) {
                stack.push(c);

            } else if (c == DIV) {
                stack.push(c);

            } else if (c == RIGHT_PAREN) {
                result.append(stack.pop());
            } else if (c == LEFT_PAREN) {
                continue;
            } else {
                result.append(c);
            }

        }
        return result.toString();
    }

    public void evaluatePostfix(String s) {
        Stack<String> stack = new Stack<>();
        String [] sArray = s.split(" ");
        for (int i = 0; i < sArray.length; i++) {
            String temp = sArray[i];
            if (temp.equals("+") ) {
                Integer first = Integer.parseInt(stack.pop());
                Integer second = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(first + second));
            } else if (temp.equals("-")) {
                Integer first = Integer.parseInt(stack.pop());
                Integer second = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(second - first));
            } else if (temp.equals("*")) {
                Integer first = Integer.parseInt(stack.pop());
                Integer second = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(second * first));
            } else if (temp.equals("/")) {
                Integer first = Integer.parseInt(stack.pop());
                Integer second = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(second / first));
            }  else {
                stack.push(temp);
            }
        }
        System.out.println(stack.pop());
    }

    public static void main(String[] args) {
        InfixToPostfix infixToPostfix = new InfixToPostfix();
//        infixToPostfix.transform("(2+((3+4)*(5*6)))");
//        infixToPostfix.transform("(((5+(7*(1+1)))*3)+(2*(1+1)))");
        infixToPostfix.evaluatePostfix("3 4 5 + *");
        infixToPostfix.evaluatePostfix("1 2 3 4 5 * + 6 * * +");
        infixToPostfix.evaluatePostfix("7 16 16 16 * * * 5 16 16 * * 3 16 * 1 + + +");
        infixToPostfix.evaluatePostfix("7 16 * 5 + 16 * 3 + 16 * 1 +");
    }
}
