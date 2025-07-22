package step13_binary_trees.lec3_hard_problems;
import java.util.*;
public class p12_morris_traversal_inorder {
    public List<Integer> inorder(TreeNode root){
        List<Integer> inorder=new ArrayList<>();
        TreeNode cur=root;
        while(cur!=null){
            //if cur.left=null then it means cur is root node(l root r) hence we add it to inorder
            if(cur.left==null){
                inorder.add(cur.val);
                cur=cur.right;
            }
            //if left exists
            else{
                //find rightmost guy in left subtree (dont take the threaded path)
                TreeNode prev=cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                }
                //only 2 options left , either the right one is null or right one is curr(threaded)
                //if null then we make a thread and take the current to left
                if(prev.right==null){
                    prev.right=cur;
                    cur=cur.left;
                }
                //if threaded then we remove the thread , add node to traversal and go to right
                else{
                    prev.right=null;
                    inorder.add(cur.val);
                    cur=cur.right;
                }
            }
        }
        return inorder;
    }
}
