package step13_binary_trees.lec3_hard_problems;

public class p14_flatten_bt {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }
}
