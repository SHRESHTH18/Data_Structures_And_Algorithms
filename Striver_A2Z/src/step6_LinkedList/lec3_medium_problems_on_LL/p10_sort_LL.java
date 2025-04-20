package step6_LinkedList.lec3_medium_problems_on_LL;

public class p10_sort_LL {


    //selection sort -TLE
//    public ListNode sortList(ListNode head) {
//        ListNode temp=head;
//        if(head==null || head.next==null){
//            return head;
//        }
//        while(temp.next!=null){
//            int minidx=findMinIdx(temp);
//            ListNode min=temp;
//            for(int i=0;i<minidx;i++){
//                min=min.next;
//            }
//            int a=temp.data;
//            temp.data=min.data;
//            min.data=a;
//            temp=temp.next;
//        }
//        return head;
//    }
//    public int findMinIdx(ListNode head){
//        int count=0;
//        ListNode temp=head;
//        int minidx=0;
//        int min=Integer.MAX_VALUE;
//        while(temp!=null){
//            if(temp.data<min){
//                min=temp.data;
//                minidx=count;
//            }
//            temp=temp.next;
//            count++;
//        }
//        return minidx;
//    }
}
