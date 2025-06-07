package step8_stack_and_queue.lec1_learning;
import java.util.*;
public class p8_min_stack {
}
class Pair{
    int x;
    int y;
    Pair(int x , int y){
        this.x=x;
        this.y=y;
    }
}
class MinStack {
    Stack<Pair> stack = new Stack<>();
    public MinStack() {

    }

    public void push(int val) {
        if(stack.empty()){
            Pair a = new Pair(val,val);
            stack.push(a);
        }
        else{
            Pair b= stack.pop();
            int min= b.y;
            stack.push(b);
            Pair c = new Pair(val , Math.min(min,val));
            stack.push(c);
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().x;
    }

    public int getMin() {
        return stack.peek().y;
    }
}
