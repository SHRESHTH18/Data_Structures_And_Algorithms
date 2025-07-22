package step14_Binary_Search_Tree;
import java.util.*;
public class p13_BST_iterator {
    //SC-O(H)
    class BSTIterator {
        Stack<TreeNode> stack= new Stack<>();
        public BSTIterator(TreeNode root) {
            push_stack(root);
        }
        public void push_stack(TreeNode node){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
        }
        public int next() {
            TreeNode el=stack.pop();
            push_stack(el.right);
            return el.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
    private List<TreeNode> inorder = new ArrayList<>();
    private int i = -1;

    public p13_BST_iterator(TreeNode root) {
        inorderTraversal(root);
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        inorder.add(root);
        inorderTraversal(root.right);
    }

    public int next() {
        i++;
        return inorder.get(i).val;
    }

    public boolean hasNext() {
        return (i < inorder.size() - 1);
    }
}
