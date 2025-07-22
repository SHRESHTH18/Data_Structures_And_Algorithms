package step13_binary_trees.lec1_traversals;
import java.util.*;
public class p8_level_wise_traversal {

    public List<List<Integer>> levelOrderApproach2(TreeNode root) {
        List<List<Integer>> ans=new ArrayList();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> res=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                res.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);

            }
            ans.add(res);
        }
        return ans;

    }


    class Pair{
        TreeNode node;
        int level;
        public Pair(TreeNode node, int level){
            this.node=node;
            this.level=level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> q= new LinkedList<>();
        if(root==null) return ans;
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair el = q.poll();
            if(el.level==ans.size()){
                ans.add(new ArrayList<>());
            }
            ans.get(el.level).add(el.node.val);
            if(el.node.left!=null) q.offer(new Pair(el.node.left,el.level+1));
            if(el.node.right!=null) q.offer(new Pair(el.node.right,el.level+1));
        }

        return ans;
    }
}
