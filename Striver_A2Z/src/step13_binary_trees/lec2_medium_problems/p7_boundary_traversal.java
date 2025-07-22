package step13_binary_trees.lec2_medium_problems;
import java.util.*;
public class p7_boundary_traversal {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here

        ArrayList<Integer> ans = new ArrayList<>();
        if(node==null) return ans;
        if(node.left!=null || node.right!=null){
            ans.add(node.data);
        }

        Node leftBoundary=node.left;
        if(leftBoundary!=null){
            while(leftBoundary.left!=null || leftBoundary.right!=null){
                ans.add(leftBoundary.data);
                if(leftBoundary.left!=null){
                    leftBoundary=leftBoundary.left;
                }
                else{
                    leftBoundary=leftBoundary.right;
                }
            }
        }


        inorder(node,ans);

        Stack<Integer> st=new Stack<>();

        Node rBound=node.right;
        if(rBound!=null){
            while(rBound.right!=null || rBound.left!=null){
                st.push(rBound.data);
                if(rBound.right!=null){
                    rBound=rBound.right;
                }
                else{
                    rBound=rBound.left;
                }
            }
        }
        while(!st.isEmpty()){
            ans.add(st.pop());
        }

        return ans;
    }

    public void inorder(Node node,ArrayList<Integer> ans){
        if(node==null) return;
        inorder(node.left,ans);
        if(node.left==null && node.right==null) ans.add(node.data);
        inorder(node.right,ans);
    }
}
