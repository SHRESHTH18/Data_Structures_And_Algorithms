package step6_LinkedList.lec1_learn_single_LL;

public class p5_search_element {
    static boolean searchKey(int n, Node head, int key) {
        // Code here
        Node temp=head;
        while(temp!=null){
            if(temp.data==key){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
}

