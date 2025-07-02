package step15_graphs.lec4_shortest_paths;
import java.util.*;
public class p3_djikstra_using_pq {
    class Pair{
        int dist;
        int node;
        public Pair(int dist,int node){
            this.dist=dist;
            this.node=node;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u= edges[i][0];
            int v=edges[i][1];
            int d= edges[i][2];
            adj.get(u).add(new Pair(d,v));
        }

        int[] dist= new int[V];
        for(int i=0;i<V;i++){
            dist[i]=(int)1e9;
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((x,y)->x.dist-y.dist);
        dist[src]=0;
        pq.add(new Pair(0,src));
        while(!pq.isEmpty()){
            Pair el= pq.poll();
            int u = el.node;

            for(Pair it:adj.get(u)){
                int d= it.dist;
                if(dist[it.node]>dist[u]+d){
                    dist[it.node]=dist[u]+d;
                    pq.offer(new Pair(dist[it.node],it.node));
                }
            }
        }

        return dist;

    }
}
