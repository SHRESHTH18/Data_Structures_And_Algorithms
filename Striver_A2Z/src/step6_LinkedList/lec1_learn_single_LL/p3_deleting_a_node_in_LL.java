package step6_LinkedList.lec1_learn_single_LL;
import java.util.Scanner;
public class p3_deleting_a_node_in_LL {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("enter n");
        int n=in.nextInt();
        System.out.println("enter array");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        Node head = constructLL(arr);
        System.out.println("old LL:");
        display(head);
        System.out.println("enter data of node to be deleted");
        int del=in.nextInt();
        Node delete= new Node(del);
        delete.next=findNext(head,delete);
        System.out.println(findNext(head,delete).data);
        deleteNode(delete);
        display(head);
    }
    static Node findNext(Node head,Node node){
        Node temp = head;
        while(temp.data!=node.data){
            temp=temp.next;
        }
        return temp.next;
    }
    static void deleteNode(Node node){
        node.data = node.next.data;
        node.next = node.next.next;
    }
    static void display(Node head){
        Node current=head;
        while(current!=null){
            System.out.print(current.data + "->");
            current=current.next;
        }
        System.out.print("null");
    }
    static Node constructLL(int arr[]) {
        // code here
        Node head = new Node(arr[0]);
        Node mover=head;
        int n=arr.length;
        for(int i=1;i<n;i++){
            Node temp=new Node(arr[i]);
            mover.next=temp;
            mover=mover.next;
        }
        return head;
    }
}
