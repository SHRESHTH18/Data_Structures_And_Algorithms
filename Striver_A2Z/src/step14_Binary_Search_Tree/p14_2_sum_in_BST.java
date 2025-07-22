package step14_Binary_Search_Tree;

public class p14_2_sum_in_BST {
    public boolean findTarget(TreeNode root, int k) {
        return search(root, root, k);
    }

    public boolean search(TreeNode root, TreeNode current, int k) {
        if (current == null) return false;

        int complement = k - current.val;

        if (find(root, current, complement)) return true;

        return search(root, current.left, k) || search(root, current.right, k);
    }

    public boolean find(TreeNode root, TreeNode exclude, int value) {
        if (root == null) return false;

        if (root.val == value && root != exclude) return true;
        else if (value < root.val) return find(root.left, exclude, value);
        else return find(root.right, exclude, value);
    }
}
