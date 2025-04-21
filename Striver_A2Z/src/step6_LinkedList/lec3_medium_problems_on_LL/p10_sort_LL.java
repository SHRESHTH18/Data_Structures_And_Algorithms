package step6_LinkedList.lec3_medium_problems_on_LL;

public class p10_sort_LL {
    //merge sort
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode middle=findMiddle(head);
        ListNode leftHead=head;
        ListNode rightHead=middle.next;
        middle.next=null;
        leftHead=sortList(leftHead);
        rightHead=sortList(rightHead);
        return merge(leftHead,rightHead);
    }
    public ListNode merge(ListNode leftHead,ListNode rightHead){
        ListNode left=leftHead;
        ListNode right=rightHead;
        ListNode head=left;
        if(left.data<right.data){
            head = left;
            left=left.next;
        }
        else{
            head=right;
            right=right.next;
        }
        ListNode temp=head;
        while(left!=null && right!=null){
            if(left.data<right.data){
                temp.next=left;
                temp=temp.next;
                left=left.next;
            }
            else{
                temp.next=right;
                temp=temp.next;
                right=right.next;
            }
        }
        while(left!=null){
            temp.next=left;
            temp=temp.next;
            left=left.next;
        }
        while(right!=null){
            temp.next=right;
            temp=temp.next;
            right=right.next;
        }
        return head;
    }
    public ListNode findMiddle(ListNode head){
        if(head==null|| head.next==null) return head;
        ListNode fast= head.next;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    
    
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
