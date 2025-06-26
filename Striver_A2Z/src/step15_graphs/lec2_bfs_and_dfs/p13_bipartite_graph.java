package step15_graphs.lec2_bfs_and_dfs;
import java.util.*;
public class p13_bipartite_graph {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;

            Queue<Integer> q = new ArrayDeque<>();
            q.offer(i);
            color[i] = 1;

            while (!q.isEmpty()) {
                int el = q.poll();
                for (int neighbor : graph[el]) {
                    if (color[neighbor] == color[el]) {
                        return false;
                    }
                    if (color[neighbor] == 0) {
                        color[neighbor] = 3 - color[el];
                        q.offer(neighbor);
                    }
                }
            }
        }

        return true;
    }
}
