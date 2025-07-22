package step13_binary_trees.lec2_medium_problems;

public class p12_symmetric_tree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return helper(root.left,root.right);
    }

    public boolean helper(TreeNode left, TreeNode right){
        if(left==null && right==null) return true; //both null
        if(left==null ||right==null) return false; // one null
        boolean l=helper(left.left,right.right);
        boolean r= helper(left.right,right.left);
        return left.val==right.val && l && r;
    }
}
