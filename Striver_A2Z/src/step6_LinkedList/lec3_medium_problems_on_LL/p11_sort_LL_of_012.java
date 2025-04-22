package step6_LinkedList.lec3_medium_problems_on_LL;

public class p11_sort_LL_of_012 {
    public ListNode sortList(ListNode head) {
        ListNode temp=head;
        int[] count=new int[3];
        while(temp!=null){
            count[temp.data]++;
            temp=temp.next;
        }
        temp=head;
        for(int i=0;i<3;i++){
            while(count[i]>0){
                temp.data=i;
                temp=temp.next;
                count[i]--;
            }
        }
        return head;
    }
}
