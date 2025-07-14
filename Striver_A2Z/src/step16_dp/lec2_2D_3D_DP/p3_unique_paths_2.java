package step16_dp.lec2_2D_3D_DP;
import java.util.*;
public class p3_unique_paths_2 {
    //tabulation
    public int uniquePathsWithObstaclesTabulation(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] ==1 || obstacleGrid[m-1][n-1]==1) return 0;
        int[][] dp = new int[m][n];
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 &&j==0) continue;
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                int up=0;
                int left=0;
                if(i>0) up=dp[i-1][j];
                if(j>0) left=dp[i][j-1];
                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePathsWithObstaclesMemoisation(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] ==1 || obstacleGrid[m-1][n-1]==1) return 0;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(m-1,n-1,dp,obstacleGrid);
    }
    public int helper(int i,int j,int[][] dp,int[][] grid){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(grid[i][j]==1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=helper(i-1,j,dp,grid);
        int left=helper(i,j-1,dp,grid);
        return dp[i][j]=up+left;
    }
}

