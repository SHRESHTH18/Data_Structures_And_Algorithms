package step13_binary_trees.lec3_hard_problems;
import java.util.*;
public class p5_nodes_at_distance_K_from_target {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        //marking parents
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                if(node.left!=null){
                    map.put(node.left,node);
                    q.offer(node.left);
                }
                if(node.right!=null){
                    map.put(node.right,node);
                    q.offer(node.right);
                }
            }
        }

        //we can use the same q used above to do our bfs traversal from target node
        // As it is currently empty

        q.offer(target);
        int dist=0;
        Set<TreeNode> visited= new HashSet<>();
        visited.add(target);
        while(!q.isEmpty()){
            if(dist==k) break;
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode node= q.poll();
                TreeNode parent=map.getOrDefault(node,null);
                if(parent!=null && !visited.contains(parent)){
                    visited.add(parent);
                    q.offer(parent);
                }
                TreeNode left=node.left;
                if(left!=null && !visited.contains(left)){
                    visited.add(left);
                    q.offer(left);
                }
                TreeNode right=node.right;
                if(right!=null && !visited.contains(right)){
                    visited.add(right);
                    q.offer(right);
                }
            }

            dist++;
        }

        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}
