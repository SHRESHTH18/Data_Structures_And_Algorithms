package step6_LinkedList.lec3_medium_problems_on_LL;

public class p9_delte_nth_node_from_last {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) return null;
        ListNode slow=head;
        ListNode fast = head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        if(fast==null){
            head=slow.next;
            return head;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if(head.next==null) return null;
//        int len=0;
//        ListNode temp=head;
//        while(temp!=null){
//            len++;
//            temp=temp.next;
//        }
//        int delete = len-n;//3
//        if(delete==0){
//            head=head.next;
//            return head;
//        }
//        int count=1;
//        temp=head;
//        while(count<delete){
//            count++;
//            temp=temp.next;
//        }
//        temp.next=temp.next.next;
//        return head;
//    }
}
