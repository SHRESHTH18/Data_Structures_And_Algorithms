package step13_binary_trees.lec2_medium_problems;
import java.util.*;
public class p1_height_of_tree {
    public int maxDepthDFS(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);
        return Math.max(lh,rh)+1;
    }

    class Pair{
        TreeNode node;
        int lvl;
        public Pair(TreeNode node, int lvl){
            this.node=node;
            this.lvl=lvl;
        }
    }
    public int maxDepth(TreeNode root) {
        Queue<Pair> q= new LinkedList<>();
        if(root==null) return 0;
        q.offer(new Pair(root,1));
        int height=1;
        while(!q.isEmpty()){
            Pair el= q.poll();
            height=el.lvl;
            if(el.node.left!=null) q.offer(new Pair(el.node.left,el.lvl+1));
            if(el.node.right!=null) q.offer(new Pair(el.node.right,el.lvl+1));
        }
        return height;
    }
}
