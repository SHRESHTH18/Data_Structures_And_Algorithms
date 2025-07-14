package step13_binary_trees.lec1_traversals;
import java.util.*;
public class p5_preorder {
    class TreeNode{
        int val;
        TreeNode left,right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root,ans);
        return ans;
    }
    public void preorder(TreeNode node, List<Integer> ans){
        if(node==null) return;
        ans.add(node.val);
        preorder(node.left,ans);
        preorder(node.right,ans);
    }
}
