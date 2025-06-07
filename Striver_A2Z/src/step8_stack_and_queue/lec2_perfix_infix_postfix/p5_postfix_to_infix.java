package step8_stack_and_queue.lec2_perfix_infix_postfix;

import java.util.Stack;

public class p5_postfix_to_infix {
    static String postToInfix(String exp) {
        // code here
        int len = exp.length();
        Stack<String> stack = new Stack<>();
        for(int i=0;i<len;i++){
            char ch= exp.charAt(i);
            if(isOperand(ch)){
                stack.push(Character.toString(ch));
            }
            else{
                String s1= stack.pop();
                String s2=stack.pop();
                String s3= '(' + s2+ch+s1+')';
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

