package step16_dp.lec3_dp_on_subsequences;
import java.util.*;
public class p10_unbounded_knapsack {
    static int knapSackTabulation(int val[], int wt[], int capacity) {
        // code here
        int n=val.length;
        int[][] dp=new int[n][capacity+1];
        for(int i=0;i<=capacity;i++){
            dp[0][i]=((int)(i/wt[0]))*val[0];
        }
        for(int i=1;i<n;i++){
            for(int cap=0;cap<=capacity;cap++){
                int nt=dp[i-1][cap];
                int take=0;
                if(cap>=wt[i]) take=val[i]+dp[i][cap-wt[i]];
                dp[i][cap]=Math.max(take,nt);
            }
        }
        return dp[n-1][capacity];
    }
    static int knapSackMemoization(int val[], int wt[], int capacity) {
        // code here
        int n=val.length;
        int[][] dp=new int[n][capacity+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return helper(n-1,capacity,val,wt,dp);
    }
    static int helper(int i, int cap, int[] val, int[] wt,int[][] dp){
        if(i==0){
            return ((int)(cap/wt[0]))*val[0];
        }
        if(dp[i][cap]!=-1) return dp[i][cap];
        int nt=helper(i-1,cap,val,wt,dp);
        int take=0;
        if(cap>=wt[i]) take=val[i]+helper(i,cap-wt[i],val,wt,dp);

        return dp[i][cap]=Math.max(take,nt);
    }
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n=val.length;
        return helper(n-1,capacity,val,wt);
    }
    static int helper(int i, int cap, int[] val, int[] wt){
        if(i==0){
            return ((int)(cap/wt[0]))*val[0];
        }
        int nt=helper(i-1,cap,val,wt);
        int take=0;
        if(cap>=wt[i]) take=val[i]+helper(i,cap-wt[i],val,wt);

        return Math.max(take,nt);
    }
}
