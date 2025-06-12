package step8_stack_and_queue.lec2_prefix_infix_postfix;
import java.util.*;
public class p2_prefix_to_infix {
    static String preToInfix(String pre_exp) {
        // code here
        Stack<String> stack = new Stack<>();
        for(int i=pre_exp.length()-1;i>=0;i--){
            char ch= pre_exp.charAt(i);
            if((ch>='a' && ch<='z')||(ch>='A' && ch<='Z')||(ch>='0' && ch<='9')){
                stack.push(Character.toString(ch));
            }
            else{
                String s1=stack.pop();
                String s2=stack.pop();
                String s3='('+s1+ch+s2+')';
                stack.push(s3);
            }
        }
        return stack.peek();
    }
}
