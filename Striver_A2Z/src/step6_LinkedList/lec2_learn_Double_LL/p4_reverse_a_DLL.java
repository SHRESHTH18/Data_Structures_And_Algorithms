package step6_LinkedList.lec2_learn_Double_LL;

public class p4_reverse_a_DLL {
    public Node reverseDLL(Node head) {
        // Your code here
        Node currentNode=head;
        Node nextNode=head;
        while(nextNode!=null){
            nextNode=currentNode.next;
            currentNode.next=currentNode.prev;
            currentNode.prev=nextNode;
            if(nextNode == null) {
                head = currentNode;
            }
            currentNode=nextNode;
        }
        return head;
    }
}
