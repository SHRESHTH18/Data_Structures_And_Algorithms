package step6_LinkedList.lec1_learn_single_LL;
import java.util.*;

public class p1_arr_to_LL {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter size of array");
        int n = in.nextInt();
        System.out.println("enter array");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        display(constructLL(arr));
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
