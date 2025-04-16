package step6_LinkedList.lec3_medium_problems_on_LL;

public class p2_reverse_linked_list {
    public ListNode reverseList(ListNode head) {
        ListNode prevNode=null;
        ListNode currentNode=head;
        ListNode nextNode=head;
        while(nextNode!=null){
            nextNode=currentNode.next;
            currentNode.next=prevNode;
            prevNode=currentNode;
            currentNode=nextNode;
        }
        return prevNode;
    }
}
