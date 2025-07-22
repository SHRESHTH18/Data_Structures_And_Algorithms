package step13_binary_trees.lec3_hard_problems;
import java.util.*;
public class p9_buildTree_post_in {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        TreeNode root=build(inorder,0,inorder.length-1,
                postorder,0,postorder.length-1,inMap);
        return root;
    }

    TreeNode build(int[] inorder,int inStart,int inEnd,
                   int[] postorder,int postStart,int postEnd,Map<Integer,Integer> map){
        if(inStart>inEnd || postStart>postEnd) return null;

        TreeNode root=new TreeNode(postorder[postEnd]);

        int inRoot=map.get(root.val);
        int left=inRoot-inStart;

        root.left=build(inorder,inStart,inRoot-1,postorder,postStart,postStart+left-1,map);
        root.right=build(inorder,inRoot+1,inEnd,postorder,postStart+left,postEnd-1,map);
        return root;
    }
}
