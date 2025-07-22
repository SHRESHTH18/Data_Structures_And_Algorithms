package step14_Binary_Search_Tree;

public class p11_bst_from_preorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,Integer.MAX_VALUE,new int[]{0});
    }
    public TreeNode helper(int[] A,int upper,int[] i){
        if(i[0]==A.length||A[i[0]]>upper) return null;
        TreeNode root=new TreeNode(A[i[0]++]);
        root.left=helper(A,root.val,i);
        root.right=helper(A,upper,i);
        return root;
    }
}
