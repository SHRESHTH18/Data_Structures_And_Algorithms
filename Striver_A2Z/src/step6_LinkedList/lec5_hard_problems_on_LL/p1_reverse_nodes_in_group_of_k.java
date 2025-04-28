package step6_LinkedList.lec5_hard_problems_on_LL;

public class p1_reverse_nodes_in_group_of_k {
    public ListNode reverseKGroup(ListNode head, int k) {
        //you can do something like measure length first and then for every k nodes call reverse function
        ListNode temp=head;
        ListNode prev=null;
        ListNode next=head;
        while(temp!=null){
            ListNode kthNode=findkth(temp,k);
            if(kthNode==null){
                if(prev!=null) prev.next=temp;
                break;
            }
            next=kthNode.next;
            kthNode.next=null;
            reverse(temp);
            if(temp==head){
                head=kthNode;
            }
            else{
                prev.next=kthNode;
            }
            prev=temp;
            temp=next;
        }
        return head;
    }
    public ListNode findkth(ListNode temp, int k){
        k--;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode current=head;
        ListNode next=head;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
}
