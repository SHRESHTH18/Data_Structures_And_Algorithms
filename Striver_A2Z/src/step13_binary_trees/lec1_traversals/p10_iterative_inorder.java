package step13_binary_trees.lec1_traversals;
import java.util.*;
public class p10_iterative_inorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> stack= new Stack<>();
        TreeNode node= root;
        while(true){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }
            else{
                if(stack.isEmpty())break;
                TreeNode el=stack.pop();
                ans.add(el.val);
                node=el.right;
            }
        }
        return ans;
    }
}
