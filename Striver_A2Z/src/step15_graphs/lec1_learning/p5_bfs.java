package step15_graphs.lec1_learning;
import java.util.*;
public class p5_bfs {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> list = new ArrayList<>();
        q.offer(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int el=q.poll();
            list.add(el);
            for(int i =0 ; i<adj.get(el).size();i++){
                int neighbor=adj.get(el).get(i);
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    q.offer(neighbor);
                }
            }
        }
        return list;
    }
}
