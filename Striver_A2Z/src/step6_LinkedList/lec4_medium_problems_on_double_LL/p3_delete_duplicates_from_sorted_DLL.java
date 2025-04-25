package step6_LinkedList.lec4_medium_problems_on_double_LL;

public class p3_delete_duplicates_from_sorted_DLL {
    Node removeDuplicates(Node head) {
        // Code Here.
        Node temp= head;
        while(temp!=null && temp.next!=null){
            int unique= temp.data;
            Node iter=temp.next;
            while(iter.next!=null && iter.data==temp.data){
                iter=iter.next;
            }
            temp.next=iter;
            if(iter!=null) iter.prev=temp;
            temp=temp.next;
        }
        return head;
    }
}
