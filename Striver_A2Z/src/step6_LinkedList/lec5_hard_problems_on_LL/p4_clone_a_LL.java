package step6_LinkedList.lec5_hard_problems_on_LL;
import java.util.*;
public class p4_clone_a_LL {

    public Node copyRandomList(Node head) {
        Node temp=head;
        while(temp!=null){
            Node dummy=new Node(temp.data);
            dummy.next=temp.next;
            temp.next=dummy;
            temp=temp.next.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.random==null){
                temp.next.random=null;
            }
            else{
                temp.next.random=temp.random.next;
            }
            temp=temp.next.next;
        }
        Node resHead=new Node(-1);
        Node res=resHead;
        temp=head;
        while(temp!=null){
            res.next=temp.next;
            temp.next=temp.next.next;
            res=res.next;
            temp=temp.next;
        }
        res.next=null;
        return resHead.next;
    }


//    public Node copyRandomList(Node head){
//        HashMap<Node,Node> map = new HashMap<>();
//        Node temp= head;
//        Node newHead=head;
//        int count=0;
//        while(temp!=null){
//            Node dummy= new Node(temp.data);
//            if(count==0) {
//                newHead=dummy;
//                count++;
//            }
//            map.put(temp,dummy);
//            temp=temp.next;
//        }
//        for(Node node:map.keySet()){
//            map.get(node).next=map.get(node.next);
//            map.get(node).random=map.get(node.random);
//        }
//        return newHead;
//    }
}
