package step13_binary_trees.lec1_traversals;
import java.util.*;
public class p9_iterative_preorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode el=st.pop();
            ans.add(el.val);
            if(el.right!=null) st.push(el.right);
            if(el.left!=null) st.push(el.left);
        }
        return ans;
    }
}
