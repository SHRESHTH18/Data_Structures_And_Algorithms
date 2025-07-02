package step15_graphs.lec3_topo_sort_and_problems;
import java.util.*;
public class p2_topological_sort_bfs_kahns {
    static List<Integer>[] constructadj(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }

        return adj;
    }

    // Function to return list containing vertices in Topological order
    static int[] topologicalSort(int V, int[][] edges) {
        List<Integer>[] adj = constructadj(V, edges);
        int[] indegree = new int[V];

        // Calculate indegree of each vertex
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj[i]) {
                indegree[neighbor]++;
            }
        }

        // Queue to store vertices with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[V];
        int index = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            result[index++] = node;

            for (int neighbor : adj[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        // Check for cycle
        if (index != V) {
            System.out.println("Graph contains a cycle!");
            return new int[0];
        }

        return result;
    }
}
