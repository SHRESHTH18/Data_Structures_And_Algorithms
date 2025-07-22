package step14_Binary_Search_Tree;
import java.util.*;
public class p9_check_BT_isBST_or_not {
    public boolean isValidBSTRange(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    boolean helper(TreeNode node, long low, long high){
        if(node==null)return true;
        return node.val<high && node.val>low && helper(node.left,low,node.val) && helper(node.right,node.val,high);

    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> in=new ArrayList<>();
        inorder(root,in);
        for(int i=0;i<in.size()-1;i++){
            if(in.get(i)>=in.get(i+1)) return false;
        }
        return true;
    }
    void inorder(TreeNode node,List<Integer> list){
        if(node==null) return;
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }
}
