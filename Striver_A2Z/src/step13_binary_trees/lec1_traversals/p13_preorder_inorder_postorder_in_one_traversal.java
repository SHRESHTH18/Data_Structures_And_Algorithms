package step13_binary_trees.lec1_traversals;
import java.util.*;
public class p13_preorder_inorder_postorder_in_one_traversal {
    public static void main(String[] args) {
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        helper(root,preorder,inorder,postorder);
        System.out.println("preorder");
        for(int i=0;i<3;i++){
            System.out.println(preorder.get(i));
        }
        System.out.println("inorder");
        for(int i=0;i<3;i++){
            System.out.println(inorder.get(i));
        }
        System.out.println("postorder");
        for(int i=0;i<3;i++){
            System.out.println(postorder.get(i));
        }

    }
    public static void helper(TreeNode node,List<Integer> preorder,List<Integer> inorder,List<Integer> postorder){
        if(node==null)return;
        int val=node.val;
        preorder.add(val);
        helper(node.left,preorder,inorder,postorder);
        inorder.add(val);
        helper(node.right,preorder,inorder,postorder);
        postorder.add(val);
    }
}
