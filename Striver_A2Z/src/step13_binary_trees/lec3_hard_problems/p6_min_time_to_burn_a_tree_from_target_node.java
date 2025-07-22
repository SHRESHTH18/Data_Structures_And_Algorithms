package step13_binary_trees.lec3_hard_problems;
import java.util.*;
public class p6_min_time_to_burn_a_tree_from_target_node {
    public static int minTime(Node root, int target) {
        // code here
        int count=0;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        Map<Node,Node> map=new HashMap<>();
        while(!q.isEmpty()){
            int n=q.size();
            count+=n;
            for(int i=0;i<n;i++){
                Node node=q.poll();
                if(node.left!=null){
                    q.offer(node.left);
                    map.put(node.left,node);
                }
                if(node.right!=null){
                    q.offer(node.right);
                    map.put(node.right,node);
                }
            }
        }


        //traversal to find target
        Node tar=findNode(root,target);

        Set<Node> visited=new HashSet<>();
        visited.add(tar);
        q.offer(tar);
        int time=0;
        while(!q.isEmpty()){
            if(visited.size()==count) break;
            int n=q.size();
            for(int i=0;i<n;i++){
                Node node=q.poll();
                Node parent=map.getOrDefault(node,null);
                if(parent!=null && !visited.contains(parent)){
                    visited.add(parent);
                    q.offer(parent);
                }
                Node left=node.left;
                if(left!=null && !visited.contains(left)){
                    visited.add(left);
                    q.offer(left);
                }
                Node right=node.right;
                if(right!=null && !visited.contains(right)){
                    visited.add(right);
                    q.offer(right);
                }
            }
            time++;
        }

        return time;

    }

    static Node findNode(Node root, int target) {
        if (root == null) return null;

        if (root.data == target) return root;

        Node left = findNode(root.left, target);
        if (left != null) return left;

        return findNode(root.right, target);
    }
}
