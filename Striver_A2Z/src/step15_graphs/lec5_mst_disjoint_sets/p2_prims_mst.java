package step15_graphs.lec5_mst_disjoint_sets;
import java.util.*;
public class p2_prims_mst {
    class Pair{
        int wt;
        int node;
        int parent;

        public Pair(int wt, int node, int parent){
            this.wt= wt;
            this.node= node;
            this.parent=parent;
        }
    }
    int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        boolean[] vis = new boolean[V];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        int sum = 0;

        pq.offer(new Pair(0, 0, -1)); // weight, node, parent

        while (!pq.isEmpty()) {
            Pair el = pq.poll();
            int node = el.node;
            int wt = el.wt;

            if (vis[node]) continue;
            vis[node] = true;
            sum += wt;

            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int edgeWt = neighbor[1];

                if (!vis[adjNode]) {
                    pq.offer(new Pair(edgeWt, adjNode, node));
                }
            }
        }
        return sum;
    }
}
