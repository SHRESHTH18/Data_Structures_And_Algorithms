package step6_LinkedList.lec3_medium_problems_on_LL;

public class p10_delete_middle_node {
    public ListNode deleteMiddle(ListNode head) {

        if(head==null || head.next==null){
            return null;
        }
        ListNode fast=head.next.next;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
