package step13_binary_trees.lec2_medium_problems;
import java.util.*;
public class p9_top_view_of_BT {
    class Pair{
        Node node;
        int col;

        public Pair(Node node, int col){
            this.node=node;
            this.col=col;
        }
    }
    ArrayList<Integer> topView(Node root){
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<Pair> q= new LinkedList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair el=q.poll();
            Node node=el.node;
            int col=el.col;

            map.putIfAbsent(col,node.data);


            if(node.left!=null) q.offer(new Pair(node.left,col-1));
            if(node.right!=null) q.offer(new Pair(node.right,col+1));
        }

        for(int temp:map.values()){
            ans.add(temp);
        }
        return ans;
    }
}
