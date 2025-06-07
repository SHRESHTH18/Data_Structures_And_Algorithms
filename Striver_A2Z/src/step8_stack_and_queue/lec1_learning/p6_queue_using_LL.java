package step8_stack_and_queue.lec1_learning;

public class p6_queue_using_LL {
}
class QueueNode
{
    int data;
    QueueNode next;
    QueueNode(int a)
    {
        data = a;
        next = null;
    }
}

class MyQueue1
{
    QueueNode front, rear;

    //Function to push an element into the queue.
    void push(int a)
    {
        // Your code here
        QueueNode newNode= new QueueNode(a);
        if(rear==null){
            front=newNode;
            rear=newNode;
        }
        else{
            rear.next=newNode;
            rear=newNode;
        }
    }

    //Function to pop front element from the queue.
    int pop()
    {
        // Your code here
        if(front==null){
            return -1;
        }
        else{
            int el=front.data;
            front=front.next;
            if(front==null){
                rear=null;//if there is no element in queue we should also set rear
                //to null nahi to rear will be pointing to the deleted element
            }
            return el;
        }
    }
}
