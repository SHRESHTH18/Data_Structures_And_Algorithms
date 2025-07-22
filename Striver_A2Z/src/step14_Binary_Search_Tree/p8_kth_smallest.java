package step14_Binary_Search_Tree;

public class p8_kth_smallest {
    public int kthSmallest(TreeNode root, int k) {
        int[] count=new int[1];
        return helper(root,k,count);
    }
    public int helper(TreeNode root,int k,int[] count){
        if(root==null) return -1;
        int left=helper(root.left,k,count);
        count[0]++;
        if(count[0]==k) return root.val;
        int right=helper(root.right,k,count);
        return left==-1?right:left;
    }
}
