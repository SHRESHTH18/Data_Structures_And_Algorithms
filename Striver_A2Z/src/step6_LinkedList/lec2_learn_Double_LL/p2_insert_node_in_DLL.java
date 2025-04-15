package step6_LinkedList.lec2_learn_Double_LL;

public class p2_insert_node_in_DLL {
    Node addNode(Node head, int p, int x) {
        // Your code here
        int count=0;
        Node insert = new Node(x);
        Node temp=head;
        while(count!=p){
            count++;
            temp=temp.next;
        }
        insert.prev=temp;
        insert.next=temp.next;
        if(temp.next!=null){
            temp.next.prev= insert;
        }
        temp.next=insert;
        return head;
    }
}
