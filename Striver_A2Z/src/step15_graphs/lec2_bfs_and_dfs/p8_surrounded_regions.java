package step15_graphs.lec2_bfs_and_dfs;
import java.util.*;
public class p8_surrounded_regions {

    //using multisource BFS
    class Pair {
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class Solution {
        public int numEnclaves(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][] vis = new int[n][m];
            Queue<Pair> q = new LinkedList<>();

            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};

            // Step 1: Traverse boundary and start BFS for all 1s
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && grid[i][j] == 1 && vis[i][j] == 0) {
                        q.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                }
            }

            // Step 2: BFS to mark all land connected to boundary
            while (!q.isEmpty()) {
                int row = q.peek().first;
                int col = q.peek().second;
                q.remove();

                for (int i = 0; i < 4; i++) {
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                            grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                        q.add(new Pair(nrow, ncol));
                        vis[nrow][ncol] = 1;
                    }
                }
            }

            // Step 3: Count unvisited land cells (enclaves)
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1 && vis[i][j] == 0) {
                        cnt++;
                    }
                }
            }

            return cnt;
        }
    }

    //using DFS
//    public void solve(char[][] board) {
//        int m=board.length;
//        int n = board[0].length;
//        boolean[][] visited = new boolean[m][n];
//        for(int i=0;i<m;i++){
//            if(board[i][0]=='O' && !visited[i][0]){
//                dfs(i,0,board,visited);
//            }
//            if(board[i][n-1]=='O' && !visited[i][n-1]){
//                dfs(i,n-1,board,visited);
//            }
//        }
//        for(int j=0;j<n;j++){
//            if(board[0][j]=='O' && !visited[0][j]){
//                dfs(0,j,board,visited);
//            }
//            if(board[m-1][j]=='O' && !visited[m-1][j]){
//                dfs(m-1,j,board,visited);
//            }
//        }
//
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(board[i][j]=='O' && !visited[i][j]){
//                    board[i][j]='X';
//                }
//            }
//        }
//    }
//    public void dfs(int i, int j,char[][] board, boolean[][] visited){
//        int m = visited.length;
//        int n = visited[0].length;
//        if(i<0 || j<0 || i==m || j==n ||board[i][j]!='O'||visited[i][j]){
//            return;
//        }
//        visited[i][j]=true;
//        dfs(i+1,j,board,visited);
//        dfs(i-1,j,board,visited);
//        dfs(i,j+1,board,visited);
//        dfs(i,j-1,board,visited);
//    }
}
