package step6_LinkedList.lec2_learn_Double_LL;

public class p3_delete_node_in_DLL {
    public Node deleteNode(Node head, int x) {
        // code here
        if(head==null) return null;
        if(head.prev==null && head.next==null){
            return null;
        }
        int count=1;
        Node temp=head;
        while(count!=x){
            temp=temp.next;
            count++;
        }
        if(temp.prev!=null){
            temp.prev.next=temp.next;
        }

        if(temp.next!=null){
            temp.next.prev=temp.prev;
            if(temp.prev==null){
                head=temp.next;
            }
        }
        return head;
    }
}
