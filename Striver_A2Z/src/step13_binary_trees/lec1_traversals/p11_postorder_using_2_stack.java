package step13_binary_trees.lec1_traversals;
import java.util.*;
public class p11_postorder_using_2_stack {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> stack1= new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node.val);
            if(node.left!=null) stack1.push(node.left);
            if(node.right!=null) stack1.push(node.right);
        }
        while(!stack2.isEmpty()){
            ans.add(stack2.pop());
        }
        return ans;
    }
}
