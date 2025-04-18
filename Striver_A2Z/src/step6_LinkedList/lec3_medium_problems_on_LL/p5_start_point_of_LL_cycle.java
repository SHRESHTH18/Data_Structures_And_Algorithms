package step6_LinkedList.lec3_medium_problems_on_LL;
import java.util.HashSet;
public class p5_start_point_of_LL_cycle {

    //optimal - tortoise hare
    public ListNode detectCycle(ListNode head) {
        ListNode slow= head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
            if(fast==slow){
                slow=head;
                while(slow!=fast){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
    //brute approach
//    public ListNode detectCycle(ListNode head) {
//        ListNode temp = head;
//        HashSet<ListNode> set = new HashSet<>();
//        while(temp!=null){
//            if(set.contains(temp)){
//                return temp;
//            }
//            set.add(temp);
//            temp=temp.next;
//        }
//        return null;
//    }
}
