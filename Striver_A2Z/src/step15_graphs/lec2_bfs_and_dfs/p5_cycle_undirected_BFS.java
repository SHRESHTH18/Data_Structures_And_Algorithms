package step15_graphs.lec2_bfs_and_dfs;
import java.util.*;
public class p5_cycle_undirected_BFS {
    class Pair{
        int node;
        int parent;

        public Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public boolean isCycle(int V, int[][] edges) {
        // Build adjacency list
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        // Check all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfsCycleCheck(i, list, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfsCycleCheck(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Pair> q = new ArrayDeque<>();
        visited[start] = true;
        q.offer(new Pair(start, -1));

        while (!q.isEmpty()) {
            Pair el = q.poll();
            int node = el.node;
            int parent = el.parent;

            for (int neighbor : adj.get(node)) {
                if (neighbor == parent) continue;

                if (visited[neighbor]) {
                    return true; // Found a back edge → cycle
                }

                visited[neighbor] = true;
                q.offer(new Pair(neighbor, node));
            }
        }

        return false;
    }
}
