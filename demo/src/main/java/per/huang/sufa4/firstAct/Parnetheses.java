package per.huang.sufa4.firstAct;

import java.util.Scanner;
import java.util.Stack;

// 1.3.4
public class Parnetheses {

    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';

    static Boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == LEFT_PAREN) {
                stack.push(c);
            }
            if (c == LEFT_BRACE) {
                stack.push(c);
            }
            if (c == LEFT_BRACKET) {
                stack.push(c);
            }
            if (c == RIGHT_PAREN) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != LEFT_PAREN ) {
                    return false;
                }
            }
            if (c == RIGHT_BRACE) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != LEFT_BRACE ) {
                    return false;
                }
            }
            if (c == RIGHT_BRACKET) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != LEFT_BRACKET ) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(isBalanced(input));
    }
}
