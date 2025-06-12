package step8_stack_and_queue.lec2_prefix_infix_postfix;
import java.util.*;
public class p6_infix_to_prefix {
}
// Java program to convert infix to prefix

class GfG {

    // Check if character is an operator
    static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' ||
                ch == '*' || ch == '/' || ch == '^');
    }

    // Get precedence of operators
    static int operatorPrecedence(char op) {
        if (op == '^') return 3;
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return -1;
    }

    // Convert infix expression to postfix notation
    static String convertInfixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        int sz = s.length();

        for (int i = 0; i < sz; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                res.append(s.charAt(i));
            } else if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() && operatorPrecedence(s.charAt(i)) <=
                        operatorPrecedence(st.peek())) {
                    res.append(st.pop());
                }
                st.push(s.charAt(i));
            }
        }

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return res.toString();
    }

    // Convert infix expression to prefix notation
    static String convertToPrefix(String infix) {
        StringBuilder sb = new StringBuilder(infix);
        sb.reverse();
        infix = sb.toString();

        char[] chars = infix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                chars[i] = ')';
            } else if (chars[i] == ')') {
                chars[i] = '(';
            }
        }

        String postfix = convertInfixToPostfix(new String(chars));
        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args) {
        String s = "(a-b/c)*(a/k-l)";
        System.out.println(convertToPrefix(s));
    }
}