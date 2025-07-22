package step13_binary_trees.lec3_hard_problems;
import java.util.*;

public class p3_width_of_bt {
    class Pair{
        TreeNode node;
        int index;
        public Pair(TreeNode node,int index){
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        int max=1;
        while(!q.isEmpty()){
            int n=q.size();
            int start=q.peek().index;
            int end=start;
            for(int i=0;i<n;i++){
                Pair el=q.poll();
                TreeNode node=el.node;
                int index=el.index;
                if(i==n-1) end=index;

                if(node.left!=null)
                    q.offer(new Pair(node.left,2*(index-start)+1));
                if(node.right!=null)
                    q.offer(new Pair(node.right,2*(index-start)+2));

            }
            max=Math.max(max,end-start+1);
        }
        return max;
    }
}
