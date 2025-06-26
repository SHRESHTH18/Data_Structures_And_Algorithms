package step8_stack_and_queue.lec4_implementation_problems;
import java.util.*;
public class p3_implementing_LRU_cache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    public void delete(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }
    public void insertAfterHead(Node head , Node node){
        node.next= head.next;
        head.next.prev = node;
        head.next= node;
        node.prev=head;
    }

    HashMap<Integer,Node> map = new HashMap<>();
    int capacity;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    public p3_implementing_LRU_cache(int capacity){
        this.capacity=capacity;
        map.clear();
        head.next= tail;
        tail.prev= head;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        delete(node);
        insertAfterHead(head,node);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            delete(node);
            insertAfterHead(head,node);
        }
        else{
            if(map.size()==capacity){
                Node node = tail.prev;
                map.remove(node.key);
                delete(node);
            }
            Node node = new Node(key,value);
            map.put(key,node);
            insertAfterHead(head,node);
        }
    }
}
