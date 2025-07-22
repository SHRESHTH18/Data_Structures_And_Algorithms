package step14_Binary_Search_Tree;

public class p7_delete_node_from_bst {
    // Helper function to find the minimum value node in a BST
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left; // keep going left
        }
        return node;
    }

    // Main function to delete a node with given value in BST
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            // Base case: tree is empty or key not found
            return null;
        }

        if (key < root.val) {
            // Key is smaller than current node → go left
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // Key is greater than current node → go right
            root.right = deleteNode(root.right, key);
        } else {
            // Found the node to delete

            // Case 1: Node has no children (leaf)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node has only right child
            if (root.left == null) {
                return root.right;
            }

            // Case 3: Node has only left child
            if (root.right == null) {
                return root.left;
            }

            // Case 4: Node has two children
            // → Find inorder successor (smallest in right subtree)
            TreeNode successor = findMin(root.right);

            // Copy successor's value to current node
            root.val = successor.val;

            // Delete the successor from right subtree
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }
}
