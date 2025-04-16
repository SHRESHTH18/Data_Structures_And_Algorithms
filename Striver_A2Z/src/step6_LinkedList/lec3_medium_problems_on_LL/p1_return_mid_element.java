package step6_LinkedList.lec3_medium_problems_on_LL;

public class p1_return_mid_element {
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
//    public ListNode middleNode(ListNode head) {
//        ListNode temp=head;
//        int count=0;
//        while(temp!=null){
//            count++;
//            temp=temp.next;
//        }
//        temp=head;
//        for(int i=0;i<Math.ceil(count/2);i++){
//            temp=temp.next;
//        }
//        return temp;
//    }
}
