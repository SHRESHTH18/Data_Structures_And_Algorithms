package step6_LinkedList.lec3_medium_problems_on_LL;

public class p15_add_2_LL {

    //without equal lengths
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry = 0;
        while( l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if(l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }


    //with equal lengths
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode t1 = l1;
//        ListNode t2 = l2;
//        int len1 = 1;
//        int len2 = 1;
//
//        // Calculate lengths
//        while (t1.next != null) {
//            len1++;
//            t1 = t1.next;
//        }
//        while (t2.next != null) {
//            len2++;
//            t2 = t2.next;
//        }
//
//        // Equalize lengths
//        if (len1 < len2) {
//            l1 = equalLength(l1, len2 - len1);
//        } else if (len1 > len2) {
//            l2 = equalLength(l2, len1 - len2);
//        }
//
//        // Add corresponding digits
//        t1 = l1;
//        t2 = l2;
//        int carry = 0;
//        ListNode prev = null;
//        while (t1 != null) {
//            int sum = t1.data + t2.data + carry;
//            carry = sum / 10;
//            t1.data = sum % 10;
//
//            prev = t1;
//            t1 = t1.next;
//            t2 = t2.next;
//        }
//
//        // If there's still a carry after last node
//        if (carry > 0) {
//            prev.next = new ListNode(carry);
//        }
//
//        return l1;
//    }
//
//    public ListNode equalLength(ListNode head, int diff) {
//        ListNode temp = head;
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//        while (diff > 0) {
//            temp.next = new ListNode(0);
//            temp = temp.next;
//            diff--;
//        }
//        return head;
//    }
}

