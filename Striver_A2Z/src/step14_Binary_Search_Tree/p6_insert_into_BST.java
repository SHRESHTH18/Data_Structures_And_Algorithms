package step14_Binary_Search_Tree;

public class p6_insert_into_BST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode temp=root;
        while(temp!=null){
            if(temp.val<val){
                if(temp.right==null){
                    temp.right=new TreeNode(val);
                    return root;
                }
                else{
                    temp=temp.right;
                }
            }
            else{
                if(temp.left==null){
                    temp.left=new TreeNode(val);
                    return root;
                }
                else{
                    temp=temp.left;
                }
            }
        }
        return root;
    }
}
