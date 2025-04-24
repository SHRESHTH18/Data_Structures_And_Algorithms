package step6_LinkedList.lec3_medium_problems_on_LL;

public class p14_add_one_to_LL {
    public ListNode addOne(ListNode head) {
        // code here.
        head = reverse(head);
        ListNode current = head;
        int carry=1;

        while(carry!=0){
            current.data+=1;

            if(current.data<10) return reverse(head);
            else{
                current.data=0;
            }

            if(current.next==null) break;
            else{
                current=current.next;
            }
        }
        current.next=new ListNode(1);
        return reverse(head);
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode current= head;
        ListNode next=head;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }



//    public ListNode addOne(ListNode head) {
//        // code here.
//        ListNode temp=head;
//        int len=0;
//        while(temp!=null){
//            len++;
//            temp=temp.next;
//        }
//        int count=0;
//        temp=head;
//        while(temp!=null){
//            if(temp.data==9){
//                count++;
//            }
//            else{
//                count=0;
//            }
//            temp=temp.next;
//        }
//        temp=head;
//        if(count==0){
//            while(temp.next!=null){
//                temp=temp.next;
//            }
//            temp.data=temp.data+1;
//        }
//        else if(count==len){
//            ListNode newnode=new ListNode(1);
//            newnode.next=head;
//            while(temp!=null){
//                temp.data=0;
//                temp=temp.next;
//            }
//            head=newnode;
//        }
//        else{
//            int i=1;
//            while(i<len-count){
//                temp=temp.next;
//                i++;
//            }
//            temp.data=temp.data+1;
//            while(temp.next!=null){
//                temp=temp.next;
//                temp.data=0;
//            }
//        }
//        return head;
//    }
}
