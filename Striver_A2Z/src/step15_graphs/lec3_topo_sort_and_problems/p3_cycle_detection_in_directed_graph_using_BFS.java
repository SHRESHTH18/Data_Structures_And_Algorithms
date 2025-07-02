package step15_graphs.lec3_topo_sort_and_problems;
import java.util.*;

public class p3_cycle_detection_in_directed_graph_using_BFS {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            adj.get(u).add(v);
        }

        int[] indegree= new int[V];
        for(int i=0;i<adj.size();i++){
            for(int el:adj.get(i)){
                indegree[el]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            count++;
            int el= q.poll();
            for(int it:adj.get(el)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }
        }
        return count!=V;


    }
}
