package per.huang.sufa4.firstAct;

import org.thymeleaf.util.MapUtils;

import java.util.HashMap;
import java.util.Stack;

/**
 * 1.3.9 补充左括号
 */
public class AbsenceLeftParen {
    private static final char RIGHT_PAREN = ')';
    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char MUL = '*';
    private static final char DIV = '/';

    private static final HashMap<Character, Character> map = new HashMap<>();

    public static void solution(String s) {
        map.put(ADD, ADD);
        map.put(SUB, SUB);
        map.put(MUL, MUL);
        map.put(DIV, DIV);
        Stack<Integer> numStack = new Stack<>();

        Stack<String> counterStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == RIGHT_PAREN) {
                if (numStack.isEmpty()) {
                    String first = counterStack.pop();
                    String second = counterStack.pop();
                    String thirty = counterStack.pop();
                    counterStack.push("(" + thirty + second + first +")");
                } else {
                    String second = numStack.pop().toString();
                    String first = numStack.pop().toString();
                    String thirty = counterStack.pop();
                    counterStack.push("(" + first +thirty + second + ")" );
                }
            } else if (map.containsKey(c)) {
                counterStack.push(Character.toString(c));
            } else {
                numStack.push(Character.getNumericValue(c));
            }
        }
        System.out.println(counterStack.pop());
    }

    public static void main(String[] args) {
        solution("1+2)*3-4)*5-6)))");
    }
}
