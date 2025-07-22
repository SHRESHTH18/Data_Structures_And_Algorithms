package step13_binary_trees.lec3_hard_problems;

public class p7_count_nodes_in_completeBT {
    public int countNodes(TreeNode root) {
        int lh=left_height(root);
        int rh=right_height(root);
        if(lh==rh) return (int)Math.pow(2,lh)-1;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    int left_height(TreeNode node){
        if(node==null) return 0;
        return 1+left_height(node.left);
    }

    int right_height(TreeNode node){
        if(node==null) return 0;
        return 1+right_height(node.right);
    }
}
