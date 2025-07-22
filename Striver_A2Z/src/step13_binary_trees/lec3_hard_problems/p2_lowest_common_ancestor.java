package step13_binary_trees.lec3_hard_problems;

public class p2_lowest_common_ancestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;
        TreeNode l=lowestCommonAncestor(root.left,p,q);
        TreeNode r= lowestCommonAncestor(root.right,p,q);

        if(l==null) return r;
        else if(r==null) return l;
        else{
            return root;
        }
    }
}
