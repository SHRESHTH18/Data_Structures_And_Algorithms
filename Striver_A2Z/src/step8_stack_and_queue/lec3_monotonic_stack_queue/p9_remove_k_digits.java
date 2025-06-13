package step8_stack_and_queue.lec3_monotonic_stack_queue;
import java.util.Stack;
public class p9_remove_k_digits {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // If k digits still need to be removed
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build the number from stack
        StringBuilder sb = new StringBuilder();
        for (char digit : stack) {
            sb.append(digit);
        }

        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // Return the result or "0" if empty
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
