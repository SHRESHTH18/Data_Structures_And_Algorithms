package step13_binary_trees.lec1_traversals;
import java.util.*;
public class p7_postorder {
    class TreeNode{
        int val;
        TreeNode left,right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public void postorder(TreeNode node,List<Integer> ans){
        if(node==null){
            return ;
        }
        postorder(node.left,ans);
        postorder(node.right,ans);
        ans.add(node.val);
    }
}
