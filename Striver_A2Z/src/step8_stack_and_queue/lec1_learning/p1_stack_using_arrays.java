package step8_stack_and_queue.lec1_learning;

public class p1_stack_using_arrays {
}
class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        // Your Code
        if(top<999){
            top++;
            arr[top]=x;
        }

    }

    public int pop() {
        // Your Code
        if (top>-1) return arr[top--];
        return -1;
    }
}