package step16_dp.lec3_dp_on_subsequences;
import java.util.*;
public class p7_01_knapsack {

    static int knapsackTabulation(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][W + 1];

        // Base case: fill first row
        for (int i = 0; i <= W; i++) {
            if (i >= wt[0]) {
                dp[0][i] = val[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                int pick = 0;
                if (j >= wt[i]) {
                    pick = val[i] + dp[i - 1][j - wt[i]];
                }
                int notpick = dp[i - 1][j];
                dp[i][j] = Math.max(pick, notpick);
            }
        }

        return dp[n - 1][W];
    }
    static int knapsackMemoization(int W, int val[], int wt[]) {
        // code here
        int n=val.length;
        int[][] dp= new int[n][W+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n-1,W,val,wt,dp);
    }
    public static int helper(int i,int cap,int[] val,int[] wt,int[][] dp){
        if(cap==0) return 0;
        if(i==0){
            if(cap>=wt[i]) return val[i];
            else return 0;
        }
        if(dp[i][cap]!=-1) return dp[i][cap];
        int pick=0;
        if(cap>=wt[i]) pick=val[i]+helper(i-1,cap-wt[i],val,wt,dp);
        int notpick=helper(i-1,cap,val,wt,dp);
        return dp[i][cap]=Math.max(pick,notpick);
    }
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n=val.length;
        return helper(n-1,W,val,wt);
    }
    public static int helper(int i,int cap,int[] val,int[] wt ){
        if(cap==0) return 0;
        if(i==0){
            if(cap>=wt[i]) return val[i];
            else return 0;
        }
        int pick=0;
        if(cap>=wt[i]) pick=val[i]+helper(i-1,cap-wt[i],val,wt);
        int notpick=helper(i-1,cap,val,wt);
        return Math.max(pick,notpick);
    }
}
