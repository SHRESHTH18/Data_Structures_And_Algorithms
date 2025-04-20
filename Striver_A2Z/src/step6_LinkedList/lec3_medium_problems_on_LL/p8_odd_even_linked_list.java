package step6_LinkedList.lec3_medium_problems_on_LL;
import java.util.ArrayList;
public class p8_odd_even_linked_list {

    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return head;
        ListNode odd=head;
        ListNode even = head.next;
        ListNode evenHead=even;
        while(even!=null && even.next!=null ){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }

//    public ListNode oddEvenList(ListNode head) {
//        if(head==null || head.next==null || head.next.next==null) return head;
//        ListNode temp=head;
//        ArrayList<Integer> list= new ArrayList<>();
//        while(temp!=null && temp.next!=null){
//            list.add(temp.data);
//            temp=temp.next.next;
//        }
//        if(temp!=null) list.add(temp.data);
//        if(head.next!=null){
//            temp=head.next;
//        }
//        while(temp!=null && temp.next!=null){
//            list.add(temp.data);
//            temp=temp.next.next;
//        }
//        if(temp!=null) list.add(temp.data);
//        temp=head;
//        int i=0;
//        while(temp!=null){
//            temp.data=list.get(i);
//            i++;
//            temp=temp.next;
//        }
//        return head;
//    }
}
