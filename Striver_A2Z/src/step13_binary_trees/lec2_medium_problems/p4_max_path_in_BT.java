package step13_binary_trees.lec2_medium_problems;

public class p4_max_path_in_BT {
    public int maxPathSum(TreeNode root) {
        int[] max=new int[1];
        max[0]=Integer.MIN_VALUE;
        // if(root.left==null && root.right==null) return root.val;
        helper(root,max);
        return max[0];
    }
    public int helper(TreeNode node, int[] max){
        if(node==null)return 0;
        int leftSum=Math.max(0,helper(node.left,max));
        int rightSum=Math.max(0,helper(node.right,max));
        max[0]=Math.max(max[0],node.val+leftSum+rightSum);
        return node.val+Math.max(leftSum,rightSum);
    }
}
