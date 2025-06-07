package step8_stack_and_queue.lec1_learning;

import java.util.Stack;

public class p7_balanced_parentheses {
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.empty()) return false;
                char ch= stack.pop();
                if((ch=='(' && s.charAt(i)==')') || (ch=='[' && s.charAt(i)==']') || (ch=='{' && s.charAt(i)=='}')){
                    continue;
                }
                else{
                    return false;
                }
            }
        }

        return stack.empty();
    }
}