package step15_graphs.lec4_shortest_paths;
import java.util.*;
public class p8_netowrk_delay_time {
    class Pair{
        int node;
        int dist;

        public Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> adj= new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int u= times[i][0];
            int v=times[i][1];
            int dist=times[i][2];
            adj.get(u).add(new Pair(v,dist));
        }
        int[] dist=new int[n+1];
        for(int i=0;i<=n;i++){
            dist[i]=(int)1e9;
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.offer(new Pair(k,0));
        dist[k]=0;
        while(!pq.isEmpty()){
            Pair el = pq.poll();
            int node=el.node;
            int d=el.dist;
            for(Pair it:adj.get(node)){
                if(dist[node]+it.dist<dist[it.node]){
                    dist[it.node]=it.dist+dist[node];
                    pq.offer(new Pair(it.node,dist[it.node]));
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i]==(int)1e9) return -1;
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}
