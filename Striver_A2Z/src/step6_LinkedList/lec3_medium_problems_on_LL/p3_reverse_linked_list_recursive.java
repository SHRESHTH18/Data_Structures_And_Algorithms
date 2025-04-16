package step6_LinkedList.lec3_medium_problems_on_LL;

public class p3_reverse_linked_list_recursive {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Recursive step:
        // Reverse the linked list starting
        // from the second node (head.next).
        ListNode newHead = reverseList(head.next);

        // Save a reference to the node following
        // the current 'head' node.
        ListNode front = head.next;

        // Make the 'front' node point to the current
        // 'head' node in the reversed order.
        front.next = head;

        // Break the link from the current 'head' node
        // to the 'front' node to avoid cycles.
        head.next = null;

        // Return the 'newHead,' which is the new
        // head of the reversed linked list.
        return newHead;
    }
}
