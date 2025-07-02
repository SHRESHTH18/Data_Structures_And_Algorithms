package step15_graphs.lec4_shortest_paths;
import java.util.*;
public class p1_shortest_path_undirected_unit_weights {




    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n= adj.size();
        int dist[] = new int[n];
        for(int i = 0;i<n;i++) dist[i] = (int)1e9;
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q. add(src);
        while(!q. isEmpty()) {
            int node = q. peek();
            q.remove();
            for(int it : adj.get(node)) {
                if(dist[node] + 1 < dist[it]) {
                    dist[it] = 1 + dist[node];
                    q.add(it);
                }
            }
        }
        for(int i = 0;i<n;i++) {
            if(dist[i] == 1e9)
            {
                dist[i] = -1;
            }
        }
        return dist;
    }
//TLE
//    class Pair{
//        int node;
//        int dist;
//
//        public Pair(int node,int dist){
//            this.node=node;
//            this.dist=dist;
//        }
//    }
//    // Function to find the shortest path from a source node to all other nodes
//    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
//        int n = adj.size();
//        int[] result = new int[n];
//        boolean[] visited = new boolean[n];
//        Queue<Pair> q = new LinkedList<>();
//
//        q.offer(new Pair(src, 0));
//        visited[src] = true;
//
//        while (!q.isEmpty()) {
//            Pair el = q.poll();
//            int node = el.node;
//            int dist = el.dist;
//
//            result[node] = dist;
//
//            for (int neighbor : adj.get(node)) {
//                if (!visited[neighbor]) {
//                    visited[neighbor] = true;
//                    q.offer(new Pair(neighbor, dist + 1));
//                }
//            }
//        }
//
//        for(int i=0;i<result.length;i++){
//            if(i!=src && result[i]==0){
//                result[i]=-1;
//            }
//        }
//        return result;
//    }
}
