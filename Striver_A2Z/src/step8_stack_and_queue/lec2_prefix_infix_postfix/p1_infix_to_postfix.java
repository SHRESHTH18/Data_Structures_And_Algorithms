package step8_stack_and_queue.lec2_prefix_infix_postfix;
import java.util.*;
public class p1_infix_to_postfix {
    public static String infixToPostfix(String s) {
        // code here
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i) >='a' && s.charAt(i)<='z')|| (s.charAt(i) >='A' && s.charAt(i)<='Z')||(s.charAt(i) >='0' && s.charAt(i)<='9')){
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i)=='('){
                stack.push('(');
            }
            else if(s.charAt(i)==')'){
                while(stack.peek()!='('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else{
                if(stack.empty()){
                    stack.push(s.charAt(i));
                }
                else{
                    while(!stack.empty() && Precedence(s.charAt(i))<=Precedence(stack.peek())){
                        sb.append(stack.pop());
                    }
                    stack.push(s.charAt(i));
                }
            }
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public static int Precedence(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

}
