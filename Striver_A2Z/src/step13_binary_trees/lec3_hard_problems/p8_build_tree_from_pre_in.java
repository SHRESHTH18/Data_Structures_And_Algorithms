package step13_binary_trees.lec3_hard_problems;
import java.util.*;
public class p8_build_tree_from_pre_in {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }

        TreeNode root=build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
        return root;
    }
    public TreeNode build(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart, int inEnd,Map<Integer,Integer> map){
        if(preStart>preEnd || inStart>inEnd) return null;

        TreeNode root=new TreeNode(preorder[preStart]);

        int inRoot=map.get(root.val);
        int numsLeft=inRoot-inStart;

        root.left=build(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,map);
        root.right=build(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,map);
        return root;
    }
}
