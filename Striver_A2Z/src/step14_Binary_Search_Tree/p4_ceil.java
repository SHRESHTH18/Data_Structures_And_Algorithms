package step14_Binary_Search_Tree;

public class p4_ceil {
    int findCeil(Node root, int key) {
        // code here
        if(root==null) return -1;
        int ceil=Integer.MIN_VALUE;
        while(root!=null){
            if(root.data==key){
                ceil=key;
                break;
            }
            else if(root.data<key){
                root=root.right;
            }
            else{
                ceil=root.data;
                root=root.left;
            }
        }
        return ceil==Integer.MIN_VALUE?-1:ceil;
    }
}
