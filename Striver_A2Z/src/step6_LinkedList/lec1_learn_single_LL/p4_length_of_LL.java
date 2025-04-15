package step6_LinkedList.lec1_learn_single_LL;

public class p4_length_of_LL {
    public int getCount(Node head) {
        // code here
        int count=0;
        Node current=head;
        while(current!=null){
            count++;
            current=current.next;
        }
        return count;
    }
}
