package step13_binary_trees.lec2_medium_problems;

public class p5_same_trees {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        boolean left=isSameTree(p.left,q.left);
        boolean right=isSameTree(p.right,q.right);
        return p.val==q.val && left && right;
    }
}
