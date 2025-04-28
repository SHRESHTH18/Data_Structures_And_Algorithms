package step6_LinkedList.lec5_hard_problems_on_LL;
import java.util.*;
public class p3_flatten_LL {
    //optimised approach
    Node flatten(Node root) {
        // code here
        if(root==null || root.next==null) return root;
        Node mergedHead= flatten(root.next);
        return merge2lists(root,mergedHead);

    }
    Node merge2lists(Node list1,Node list2){
        Node dummy = new Node(-1);
        Node res=dummy;
        while(list1!=null && list2!=null){
            if(list1.data<list2.data){
                res.bottom=list1;
                res=list1;
                list1=list1.bottom;
            }
            else{
                res.bottom=list2;
                res=list2;
                list2=list2.bottom;
            }
            res.next=null;
        }
        if(list1!=null){
            res.bottom=list1;
        }
        else{
            res.bottom=list2;
        }
        return dummy.bottom;
    }

//brute - add all elements to a list then sort it
//    Node flatten(Node root) {
//        // code here
//        if(root==null) return null;
//        ArrayList<Integer> list = new ArrayList<>();
//        Node temp = root;
//        while(temp!=null){
//            Node vert=temp;
//            while(vert!=null){
//                list.add(vert.data);
//                vert=vert.bottom;
//            }
//            temp=temp.next;
//        }
//
//        Collections.sort(list);
//        Node newHead= new Node(list.get(0));
//        temp=newHead;
//        for(int i=1;i<list.size();i++){
//            Node newNode= new Node(list.get(i));
//            temp.bottom=newNode;
//            temp=temp.bottom;
//        }
//        return newHead;
//    }
}
