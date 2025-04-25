package step6_LinkedList.lec4_medium_problems_on_double_LL;

public class p1_delete_occurrences_of_key {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        Node temp=head;
        while(temp!=null){
            if(temp.data==x){
                if(temp==head){
                    head=temp.next;
                    head.prev=null;
                }
                else if(temp.next==null){
                    temp.prev.next=null;
                }
                else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
            }
            temp=temp.next;
        }
        return head;

    }
}
