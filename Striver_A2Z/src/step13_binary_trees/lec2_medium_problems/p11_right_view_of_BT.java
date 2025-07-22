package step13_binary_trees.lec2_medium_problems;
import java.util.*;
public class p11_right_view_of_BT {
    //we dont need the extra map structure . we can directly add it to the list.
    public List<Integer> rightSideViewSpace(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        int level=0;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                if(i==n-1) ans.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            level++;
        }


        return ans;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        HashMap<Integer,Integer> map=new HashMap<>();
        int level=0;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                if(i==n-1) map.put(level,node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            level++;
        }

        for(int temp:map.values()){
            ans.add(temp);
        }
        return ans;
    }
}
