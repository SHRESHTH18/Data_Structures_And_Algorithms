package step13_binary_trees.lec2_medium_problems;
import java.util.*;
public class p6_zigzag_level_traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return ans;
        boolean flag=false;
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode el=q.poll();
                if(el.left!=null) q.offer(el.left);
                if(el.right!=null) q.offer(el.right);
                list.add(el.val);
            }
            if(flag){
                Collections.reverse(list);
                ans.add(list);
            }
            else ans.add(list);
            flag=!flag;
        }
        return ans;
    }
}
