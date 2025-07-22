package step14_Binary_Search_Tree;

public class p5_floor {
    public static int floor(Node root, int x) {
        // Code here
        if(root==null) return -1;
        int floor=Integer.MAX_VALUE;
        while(root!=null){
            if(root.data==x){
                return x;
            }
            else if(root.data<x){
                floor=root.data;
                root=root.right;
            }
            else{
                root=root.left;
            }
        }
        return floor==Integer.MAX_VALUE?-1:floor;
    }
}
