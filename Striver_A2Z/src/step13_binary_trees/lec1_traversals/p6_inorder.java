package step13_binary_trees.lec1_traversals;
import java.util.*;
public class p6_inorder {
    class TreeNode{
        int val;
        TreeNode left,right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public void inorder(TreeNode node, List<Integer> ans){
        if(node==null) return ;
        inorder(node.left,ans);
        ans.add(node.val);
        inorder(node.right,ans);
    }
}
