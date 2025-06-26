package step15_graphs.lec2_bfs_and_dfs;
import java.util.*;
public class p1_num_provinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }

    public void bfs(int node, int[][] isConnected, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 0; i < isConnected[curr].length; i++) {
                if (isConnected[curr][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
