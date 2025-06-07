package step8_stack_and_queue.lec1_learning;
import java.util.*;
public class p4_implement_queue_using_stack {

}
class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2= new Stack<>();
    public MyQueue() {

    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        int len=s1.size();
        for(int i=0;i<len-1;i++){
            s2.push(s1.pop());
        }
        int el = s1.pop();
        for(int i=0;i<len-1;i++){
            s1.push(s2.pop());
        }
        return el;
    }

    public int peek() {
        int len=s1.size();
        for(int i=0;i<len-1;i++){
            s2.push(s1.pop());
        }
        int el = s1.pop();
        s1.push(el);
        for(int i=0;i<len-1;i++){
            s1.push(s2.pop());
        }
        return el;
    }

    public boolean empty() {
        return s1.size()==0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
