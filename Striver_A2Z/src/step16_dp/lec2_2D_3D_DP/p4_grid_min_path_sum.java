package step16_dp.lec2_2D_3D_DP;
import java.util.*;
public class p4_grid_min_path_sum {

    //tabulation
    public int minPathSumTabulation(int[][] grid) {
        int m=grid.length;
        int n= grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j]=grid[i][j];
                    continue;
                }
                int up=(int)1e9;
                int left= (int)1e9;
                if(i>0) up=grid[i][j]+dp[i-1][j];
                if(j>0) left=grid[i][j]+dp[i][j-1];
                dp[i][j]=Math.min(up,left);
            }
        }

        return dp[m-1][n-1];
    }
    //memoization
    public int minPathSumMemoization(int[][] grid) {
        int m=grid.length;
        int n= grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(m-1,n-1,grid,dp);
    }
    public int helper(int i , int j, int[][] grid,int[][] dp){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return (int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=grid[i][j]+helper(i-1,j,grid,dp);
        int left= grid[i][j] + helper(i,j-1,grid,dp);
        return dp[i][j]=Math.min(up,left);
    }
    //recursive
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n= grid[0].length;
        return helper(m-1,n-1,grid);
    }
    public int helper(int i , int j, int[][] grid){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return (int)1e9;
        int up=grid[i][j]+helper(i-1,j,grid);
        int left= grid[i][j] + helper(i,j-1,grid);
        return Math.min(up,left);
    }
    //using djikstra
    class Solution {
        class Pair{
            int i;
            int j;
            int wt;
            public Pair(int i, int j , int wt){
                this.i=i;
                this.j=j;
                this.wt=wt;
            }
        }
        public int minPathSum(int[][] grid) {
            int m=grid.length;
            int n= grid[0].length;
            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
            pq.offer(new Pair(0,0,grid[0][0]));
            while(!pq.isEmpty()){
                Pair el = pq.poll();
                int i=el.i;
                int j= el.j;
                int wt=el.wt;
                if(i==m-1 && j==n-1) return wt;
                if(i!=m-1) pq.offer(new Pair(i+1,j,wt+grid[i+1][j]));
                if(j!=n-1) pq.offer(new Pair(i,j+1,wt+grid[i][j+1]));
            }
            return 0;
        }

    }
}
