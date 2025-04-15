package step6_LinkedList.lec1_learn_single_LL;

import java.util.Scanner;

public class p2_insertion_at_end {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n = in.nextInt();

    }
    static Node insertAtEnd(Node head,int x){
        Node newNode=new Node(x);
        if(head==null){
            head=newNode;
            return head;
        }
        Node temp = head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next = newNode;
        return head;
    }
    static void display(Node head){
        Node current=head;
        while(current!=null){
            System.out.print(current.data + "->");
            current=current.next;
        }
        System.out.print("null");
    }
}
