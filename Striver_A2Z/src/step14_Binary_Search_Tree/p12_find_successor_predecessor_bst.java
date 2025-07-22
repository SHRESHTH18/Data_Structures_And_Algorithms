package step14_Binary_Search_Tree;
import java.util.*;
public class p12_find_successor_predecessor_bst {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        ArrayList<Node> ans=new ArrayList<>();
        Node pre=new Node(-1);
        Node node=root;
        while(node!=null){
            if(node.data>=key){
                node=node.left;
            }
            else{
                pre=node;
                node=node.right;
            }
        }
        ans.add(pre);
        node=root;
        Node suc=new Node(-1);
        while(node!=null){
            if(node.data<=key){
                node=node.right;
            }
            else{
                suc=node;
                node=node.left;
            }
        }
        ans.add(suc);
        return ans;
    }
}
