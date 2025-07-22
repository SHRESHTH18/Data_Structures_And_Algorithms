package step13_binary_trees.lec2_medium_problems;

public class p2_balanced_bt {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int lh=height(root.left);
        int rh=height(root.right);
        if(Math.abs(rh-lh)>1) return false;

        boolean left=isBalanced(root.left);
        boolean right=isBalanced(root.right);
        if(left && right) return true;
        return false;
    }
    public int height (TreeNode node){
        if(node==null) return 0;
        int lh=height(node.left);
        int rh=height(node.right);
        return 1+Math.max(lh,rh);
    }
}
