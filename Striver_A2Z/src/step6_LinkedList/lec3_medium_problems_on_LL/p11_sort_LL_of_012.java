package step6_LinkedList.lec3_medium_problems_on_LL;

public class p11_sort_LL_of_012 {
    public ListNode sortList(ListNode head) {
        ListNode temp=head;
        ListNode head0=new ListNode(-1);
        ListNode head1=new ListNode(-1);
        ListNode head2=new ListNode(-1);
        ListNode temp0=head0;
        ListNode temp1=head1;
        ListNode temp2=head2;

        while(temp!=null){
            if(temp.data==0){
                temp0.next=temp;
                temp0=temp0.next;
            }
            else if(temp.data==1){
                temp1.next=temp;
                temp1=temp1.next;
            }
            else{
                temp2.next=temp;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        if (head1.next != null) {
            temp0.next = head1.next;
        } else {
            temp0.next = head2.next;
        }
        temp1.next=head2.next;
        temp2.next=null;
        ListNode newHead=head0.next;
        return newHead;
    }

    //O(2N)
//    public ListNode sortList(ListNode head) {
//        ListNode temp=head;
//        int[] count=new int[3];
//        while(temp!=null){
//            count[temp.data]++;
//            temp=temp.next;
//        }
//        temp=head;
//        for(int i=0;i<3;i++){
//            while(count[i]>0){
//                temp.data=i;
//                temp=temp.next;
//                count[i]--;
//            }
//        }
//        return head;
//    }
}
