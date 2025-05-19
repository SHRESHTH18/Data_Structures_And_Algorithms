package step7_Recursion.Lec1_Get_A_Strong_Hold;
import java.util.Stack;
public class p5_reverse_stack_using_recursion {
    static void reverse(Stack<Integer> s) {
        // add your code here
        if(!s.isEmpty()){
            int temp=s.pop();
            reverse(s);
            helper(s,temp);
        }
        else{
            return;
        }

    }
    static void helper(Stack<Integer> s , int temp){
        if(s.isEmpty()){
            s.push(temp);
        }
        else{
            int a=s.pop();
            helper(s,temp);
            s.push(a);
        }
    }
}
