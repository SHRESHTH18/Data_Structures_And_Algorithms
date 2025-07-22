package step13_binary_trees.lec3_hard_problems;

public class p4_children_sum_property {
    public static int isSumProperty(Node root) {
        // add your code here
        boolean a=helper(root);
        return a?1:0;
    }
    public static boolean helper(Node node){

        if (node == null || (node.left == null && node.right == null))
            return true;

        int leftVal = (node.left != null) ? node.left.data : 0;
        int rightVal = (node.right != null) ? node.right.data : 0;

        boolean leftCheck = helper(node.left);
        boolean rightCheck = helper(node.right);

        return (node.data == leftVal + rightVal) && leftCheck && rightCheck;
    }
}
