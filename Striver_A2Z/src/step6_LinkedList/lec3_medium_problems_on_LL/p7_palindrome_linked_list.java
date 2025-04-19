package step6_LinkedList.lec3_medium_problems_on_LL;

public class p7_palindrome_linked_list {
    public boolean isPalindrome(ListNode head) {
        if(head==null ||head.next==null) return true;
        ListNode fast=head;
        ListNode slow=head;
        ListNode temp=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode tail=reverseLL(slow);
        while(tail!=null){
            if(temp.data!=tail.data){
                return false;
            }
            temp=temp.next;
            tail=tail.next;
        }
        return true;
    }
    public ListNode reverseLL(ListNode head){
        ListNode prevNode=null;
        ListNode currentNode=head;
        ListNode nextNode = head;
        while(nextNode!=null){
            nextNode=currentNode.next;
            currentNode.next=prevNode;
            prevNode=currentNode;
            currentNode=nextNode;
        }
        return prevNode;
    }
}
