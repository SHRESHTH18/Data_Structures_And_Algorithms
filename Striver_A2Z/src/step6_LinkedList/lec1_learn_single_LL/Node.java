package step6_LinkedList.lec1_learn_single_LL;

public class Node {
    int data;
    Node next;

    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

