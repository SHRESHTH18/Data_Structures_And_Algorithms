package step15_graphs.lec4_shortest_paths;
import java.util.*;
public class p11_bellman_ford {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e8);
        dist[src]=0;
        for(int i =0;i<V;i++){
            for(int j=0;j<edges.length;j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int d = edges[j][2];
                if(dist[u]==(int)1e8) continue;
                if(dist[u]+d<dist[v]){
                    dist[v]=dist[u]+d;
                }
            }
        }
        for(int j=0;j<edges.length;j++){
            int u = edges[j][0];
            int v = edges[j][1];
            int d = edges[j][2];
            if(dist[u]==(int)1e8) continue;
            if(dist[u]+d<dist[v]){

                dist[v]=dist[u]+d;
                return new int[]{-1};
            }
        }
        return dist;
    }
}
