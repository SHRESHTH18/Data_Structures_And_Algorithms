package step14_Binary_Search_Tree;

public class p10_lca_in_bst {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<root.val && q.val<root.val)
            return lowestCommonAncestor(root.left,p,q);
        else if(p.val>root.val && q.val>root.val)
            return lowestCommonAncestor(root.right,p,q);
        else{
            return root;
        }
    }
}
