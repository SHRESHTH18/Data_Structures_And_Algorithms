package step16_dp.lec3_dp_on_subsequences;
import java.util.*;
public class p5_count_partitions_with_given_diff {
    int countPartitionsMemoization(int[] arr, int d) {
        // code here
        int n=arr.length;
        int total=0;
        for(int i=0;i<n;i++){
            total+=arr[i];
        }
        int[][] dp = new int[n][total+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n-1,0,total,arr,d,dp);

    }
    int helper(int i, int sum,int total,int[] arr,int d,int[][] dp){
        if(i==-1){
            if(sum - (total-sum)==d)return 1;
            else return 0;
        }
        if(dp[i][sum]!=-1) return dp[i][sum];
        int take=helper(i-1,sum+arr[i],total,arr,d,dp);
        int notTake=helper(i-1,sum,total,arr,d,dp);
        return dp[i][sum]=take+notTake;
    }
    int countPartitions(int[] arr, int d) {
        // code here
        int n=arr.length;
        int total=0;
        for(int i=0;i<n;i++){
            total+=arr[i];
        }
        return helper(n-1,0,total,arr,d);

    }
    int helper(int i, int sum,int total,int[] arr,int d){
        if(i==-1){
            if(sum - (total-sum)==d)return 1;
            else return 0;
        }
        int take=helper(i-1,sum+arr[i],total,arr,d);
        int notTake=helper(i-1,sum,total,arr,d);
        return take+notTake;
    }
}
