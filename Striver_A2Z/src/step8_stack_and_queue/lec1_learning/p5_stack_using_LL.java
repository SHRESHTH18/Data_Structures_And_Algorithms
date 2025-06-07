package step8_stack_and_queue.lec1_learning;

public class p5_stack_using_LL {
}

class MyStack2 {
     class StackNode {
         int data;
         StackNode next;
         StackNode(int a) {
             data = a;
             next = null;
         }
     }
    StackNode top;

    // Function to push an integer into the stack.
    void push(int a) {
        // Add your code here
        StackNode newNode = new StackNode(a);
        newNode.next=top;
        top=newNode;
    }

    // Function to remove an item from top of the stack.
    int pop() {
        // Add your code here
        if(top==null) return-1;
        int a= top.data;
        top=top.next;
        return a;
    }
}
