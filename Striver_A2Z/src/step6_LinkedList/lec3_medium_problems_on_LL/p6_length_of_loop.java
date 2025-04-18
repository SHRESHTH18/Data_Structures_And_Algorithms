package step6_LinkedList.lec3_medium_problems_on_LL;
import java.util.HashMap;
public class p6_length_of_loop {
    public int findLengthOfLoop(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            if(map.containsKey(temp)){
                return count-map.get(temp);
            }
            map.put(temp,count);
            temp=temp.next;
        }
        return 0;
    }
}
