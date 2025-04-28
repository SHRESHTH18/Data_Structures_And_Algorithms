package step6_LinkedList.lec5_hard_problems_on_LL;

public class p2_rotate_a_LL {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        ListNode slow=head;
        ListNode fast = head;
        int rotate=k%len;
        while(rotate>0){
            fast=fast.next;
            rotate--;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        fast.next=head;
        head=slow.next;
        slow.next=null;
        return head;
    }
}
