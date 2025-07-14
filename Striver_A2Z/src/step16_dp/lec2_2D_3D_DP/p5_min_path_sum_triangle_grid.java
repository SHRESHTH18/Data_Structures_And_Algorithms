package step16_dp.lec2_2D_3D_DP;
import java.util.*;

public class p5_min_path_sum_triangle_grid {

    public int minimumTotalSpaceOptimised(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] next = new int[n];

        // Base case: last row
        for (int j = 0; j < triangle.get(n - 1).size(); j++) {
            next[j] = triangle.get(n - 1).get(j);
        }

        // Bottom-up DP
        for (int i = n - 2; i >= 0; i--) {
            int[] curr = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                int down = next[j];
                int diag = next[j + 1];
                curr[j] = triangle.get(i).get(j) + Math.min(down, diag);
            }
            next = curr;  // move up
        }

        return next[0];
    }
    public int minimumTotalTabulation(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // Base case: copy the last row
        for (int j = 0; j < triangle.get(n - 1).size(); j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        // Bottom-up computation
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int down = dp[i + 1][j];
                int diag = dp[i + 1][j + 1];
                dp[i][j] = triangle.get(i).get(j) + Math.min(down, diag);
            }
        }

        return dp[0][0];
    }
    public int minimumTotalMemoization(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,0,triangle,dp);
    }
    public int helper(int i,int j,List<List<Integer>> triangle,int[][] dp){
        if(i==triangle.size()-1) return triangle.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        int down=triangle.get(i).get(j)+helper(i+1,j,triangle,dp);
        int right=triangle.get(i).get(j) +helper(i+1,j+1,triangle,dp);
        return dp[i][j]=Math.min(down,right);

    }

    //recursion
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int n=triangle.get(m-1).size();
        return helper(0,0,triangle);
    }
    public int helper(int i,int j,List<List<Integer>> triangle){
        if(i==triangle.size()-1) return triangle.get(i).get(j);
        if(j>=triangle.get(i).size()) return (int)1e9;
        int down=triangle.get(i).get(j)+helper(i+1,j,triangle);
        int right=triangle.get(i).get(j) +helper(i+1,j+1,triangle);
        return Math.min(down,right);

    }
}
