package step15_graphs.lec4_shortest_paths;
import java.util.*;
public class p9_count_number_of_shortest_paths {


    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<roads.length;i++){
            int u= roads[i][0];
            int v= roads[i][1];
            int dist= roads[i][2];
            adj.get(u).add(new Pair(v,dist));
            adj.get(v).add(new Pair(u,dist));
        }
        PriorityQueue < Pair > pq = new PriorityQueue < Pair > ((x, y) -> x.first - y.first);

        // Initializing the dist array and the ways array
        // along with their first indices.
        int[] dist = new int[n];
        int[] ways = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        // Define modulo value
        int mod = (int)(1e9 + 7);

        // Iterate through the graph with the help of priority queue
        // just as we do in Dijkstra's Algorithm.
        while (pq.size() != 0) {
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int edW = it.second;

                // This ‘if’ condition signifies that this is the first
                // time we’re coming with this short distance, so we push
                // in PQ and keep the no. of ways the same.
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dis + edW, adjNode));
                    ways[adjNode] = ways[node];
                }

                // If we again encounter a node with the same short distance
                // as before, we simply increment the no. of ways.
                else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        // Finally, we return the no. of ways to reach
        // (n-1)th node modulo 10^9+7.
        return ways[n - 1] % mod;
    }

    //TLE
//    class Pair{
//        int node;
//        int dist;
//        public Pair(int node,int dist){
//            this.node=node;
//            this.dist=dist;
//        }
//    }
//    public int countPaths(int n, int[][] roads) {
//        List<List<Pair>> adj = new ArrayList<>();
//        for(int i=0;i<n;i++){
//            adj.add(new ArrayList<>());
//        }
//
//        for(int i=0;i<roads.length;i++){
//            int u= roads[i][0];
//            int v= roads[i][1];
//            int dist= roads[i][2];
//            adj.get(u).add(new Pair(v,dist));
//            adj.get(v).add(new Pair(u,dist));
//        }
//        int[] dist= new int[n];
//        for(int i=0;i<n;i++){
//            dist[i]=(int)1e9;
//        }
//
//        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.dist-b.dist);
//
//        pq.offer(new Pair(0,0));
//        dist[0]=0;
//        int min=Integer.MAX_VALUE;
//        int count=0;
//        int mod= (int)1e9 +7;
//        while(!pq.isEmpty()){
//            Pair el= pq.poll();
//            int node= el.node;
//            int d=el.dist;
//            if(d>min) continue;
//            if(node==n-1){
//                if(d==min){
//                    count=(count+1)%mod;
//                }
//                else if(d<min){
//                    count=1;
//                    min=d;
//                }
//            }
//            for(Pair it : adj.get(node)){
//                if(el.dist+it.dist<=dist[it.node]){
//                    dist[it.node]=el.dist+it.dist;
//                    pq.offer(new Pair(it.node,dist[it.node]));
//                }
//            }
//        }
//        return count;
//    }
}
