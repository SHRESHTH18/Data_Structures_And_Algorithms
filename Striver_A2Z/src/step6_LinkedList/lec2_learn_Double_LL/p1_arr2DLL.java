package step6_LinkedList.lec2_learn_Double_LL;

public class p1_arr2DLL {
    Node constructDLL(int arr[]) {
        // Code here
        Node head=new Node(arr[0]);
        int n=arr.length;
        Node prevNode = head;
        for(int i=1;i<n;i++){
            Node temp = new Node(arr[i]);
            prevNode.next=temp;
            temp.prev=prevNode;
            prevNode=prevNode.next;
        }
        return head;
    }
}
