package step13_binary_trees.lec2_medium_problems;

public class p3_diameter_of_BT {
    public int diameterOfBinaryTreeOptimal(TreeNode root) {
        int[] max = new int[1];
        helper(root, max);
        return max[0];
    }

    public int helper(TreeNode node, int[] max) {
        if (node == null) return 0;
        int lh = helper(node.left, max);
        int rh = helper(node.right, max);
        max[0] = Math.max(max[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int lh=0,rh=0;
        if(root.left!=null)lh=1+height(root.left);
        if(root.right!=null) rh = 1+height(root.right);

        int left=diameterOfBinaryTree(root.left);
        int right=diameterOfBinaryTree(root.right);
        return Math.max(lh+rh,Math.max(left,right));

    }
    public int height(TreeNode node){
        int lh=0;
        int rh=0;
        if(node.left!=null)lh = 1+height(node.left);
        if(node.right!=null)rh = 1+height(node.right);
        return Math.max(lh,rh);
    }
}
