package step6_LinkedList.lec3_medium_problems_on_LL;
import java.util.HashSet;
public class p4_detect_cycle_in_LL {

    //optimal
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    //works but takes 5ms
//    public boolean hasCycle(ListNode head) {
//        HashSet<ListNode> set = new HashSet<>();
//        ListNode temp=head;
//        while(temp!=null){
//            if(set.contains(temp)){
//                return true;
//            }
//            set.add(temp);
//            temp=temp.next;
//        }
//        return false;
//    }

    //works only if linked list contains unique elements.
//    public boolean hasCycle(ListNode head) {
//        HashSet<Integer> set = new HashSet<>();
//        ListNode temp=head;
//        while(temp!=null){
//            if(set.contains(temp.data)){
//                return true;
//            }
//            set.add(temp.data);
//            temp=temp.next;
//        }
//        return false;
//    }
}
