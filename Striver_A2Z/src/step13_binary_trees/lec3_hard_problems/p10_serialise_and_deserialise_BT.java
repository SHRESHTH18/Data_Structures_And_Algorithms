package step13_binary_trees.lec3_hard_problems;
import java.util.*;
public class p10_serialise_and_deserialise_BT {
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                sb.append("null ");
                continue;
            }
            sb.append(node.val+" ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        Queue<TreeNode> q= new LinkedList<>();
        String[] nodes=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);
        for(int i=1;i<nodes.length;i++){
            TreeNode parent=q.poll();
            if(!nodes[i].equals("null")){
                TreeNode left=new TreeNode(Integer.parseInt(nodes[i]));
                parent.left=left;
                q.offer(left);
            }
            else{
                parent.left=null;
            }

            if(!nodes[++i].equals("null")){
                TreeNode right=new TreeNode(Integer.parseInt(nodes[i]));
                parent.right=right;
                q.offer(right);
            }
            else{
                parent.right=null;
            }
        }

        return root;
    }
}
