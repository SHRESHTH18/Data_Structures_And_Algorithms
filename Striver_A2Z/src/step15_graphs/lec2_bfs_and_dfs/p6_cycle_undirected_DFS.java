package step15_graphs.lec2_bfs_and_dfs;
import java.util.*;
public class p6_cycle_undirected_DFS {
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
                if (dfs(i,-1, list, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        // go to all adjacent nodes
        for(int adjacentNode: adj.get(node)) {
            if(!vis[adjacentNode]) {
                if(dfs(adjacentNode, node, adj,vis) == true)
                    return true;
            }
            // if adjacent node is visited and is not its own parent node
            else if(adjacentNode != parent) return true;
        }
        return false;

    }
}
