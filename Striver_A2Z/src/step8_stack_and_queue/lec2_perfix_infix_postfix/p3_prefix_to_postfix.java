package step8_stack_and_queue.lec2_perfix_infix_postfix;

import java.util.Stack;

public class p3_prefix_to_postfix {
    static String preToPost(String pre_exp) {
        // code here
        int len = pre_exp.length();
        Stack<String> stack = new Stack<>();
        for(int i=len-1;i>=0;i--){
            char ch = pre_exp.charAt(i);
            if(isOperand(ch)){
                stack.push(Character.toString(ch));
            }
            else{
                String s1= stack.pop();
                String s2= stack.pop();
                String s3= s1+s2+ch;
                stack.push(s3);
            }
        }
        return stack.peek();

    }
    static boolean isOperand(char ch){
        if((ch<='z' && ch>='a')||(ch<='Z' && ch>='A')||(ch<='0' && ch>='9')){
            return true;
        }
        return false;
    }
}
