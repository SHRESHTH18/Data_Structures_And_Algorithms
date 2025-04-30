package step6_LinkedList.lec5_hard_problems_on_LL;
import java.util.*;
public class p4_clone_a_LL {

    public Node copyRandomList(Node head){
        HashMap<Node,Node> map = new HashMap<>();
        Node temp= head;
        Node newHead=head;
        int count=0;
        while(temp!=null){
            Node dummy= new Node(temp.data);
            if(count==0) {
                newHead=dummy;
                count++;
            }
            map.put(temp,dummy);
            temp=temp.next;
        }
        for(Node node:map.keySet()){
            map.get(node).next=map.get(node.next);
            map.get(node).random=map.get(node.random);
        }
        return newHead;
    }
}
