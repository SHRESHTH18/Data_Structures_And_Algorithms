package step6_LinkedList.lec3_medium_problems_on_LL;

public class p13_intersection_of_2LL {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1=headA;
        ListNode t2=headB;
        while(t1!=t2){
            t1=t1.next;
            t2=t2.next;
            if(t1==t2) return t1;
            if(t1==null) t1=headB;
            if(t2==null) t2=headA;
        }
        return t1;
    }



//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode tempA=headA;
//        ListNode tempB=headB;
//        int len1=0;
//        int len2=0;
//        while(tempA!=null){
//            len1++;
//            tempA=tempA.next;
//        }
//        while(tempB!=null){
//            len2++;
//            tempB=tempB.next;
//        }
//        if(len1<len2){
//            return collisionPoint(headA,headB,len2-len1);
//        }
//        else{
//            return collisionPoint(headB,headA,len1-len2);
//        }
//    }
//    //arguments-----smaller head, larger head, difference between lengths;
//    public ListNode collisionPoint(ListNode t1,ListNode t2,int d){
//        while(d>0){
//            d--;
//            t2=t2.next;
//        }
//        while(t1!=t2){
//            t1=t1.next;
//            t2=t2.next;
//        }
//        return t1;
//    }


//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode tempA=headA;
//        ListNode tempB=headB;
//        HashSet<ListNode> set= new HashSet<>();
//        while(tempA!=null){
//            set.add(tempA);
//            tempA=tempA.next;
//        }
//        while(tempB!=null){
//            if(set.contains(tempB)){
//                return tempB;
//            }
//            tempB=tempB.next;
//        }
//        return null;
//    }
}

