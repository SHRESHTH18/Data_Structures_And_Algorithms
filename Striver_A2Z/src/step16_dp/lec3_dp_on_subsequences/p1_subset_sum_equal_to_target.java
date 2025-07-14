package step16_dp.lec3_dp_on_subsequences;
import java.util.*;
public class p1_subset_sum_equal_to_target {

    static Boolean isSubsetSumTabulation(int arr[], int sum) {
        // code here
        int n=arr.length;
        boolean[][] dp =new boolean[n][10001];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        dp[0][arr[0]]=true;
        for(int i=1;i<n;i++){
            for(int j=0;j<10001;j++){
                boolean pick=false;
                if(j>=arr[i]) pick=dp[i-1][j-arr[i]];
                boolean notpick=dp[i-1][j];

                dp[i][j]=pick||notpick;
            }
        }
        return dp[n-1][sum];
    }

    static Boolean isSubsetSumMemoisation(int arr[], int sum) {
        // code here
        int n=arr.length;
        int[][] dp =new int[200][10001];
        for(int i=0;i<200;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n-1,sum,arr,dp);
    }
    public static Boolean helper(int i,int sum,int[] arr,int[][] dp) {
        if(sum==0) return true;
        if(i==-1)return false;
        if(dp[i][sum]!=-1) return dp[i][sum]==1?true:false;

        boolean pick =false;

        if(sum>=arr[i]) pick=helper(i-1,sum-arr[i],arr,dp);
        boolean notpick=helper(i-1,sum,arr,dp);

        if(pick||notpick) dp[i][sum]=1;
        else dp[i][sum]=0;

        return pick||notpick;
    }


    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n= arr.length;
        return helper(n-1,sum,arr);
    }
    public static Boolean helper(int i,int sum,int[] arr){
        if(sum==0) return true;
        if(i==0)return arr[0]==sum;
        boolean pick = false;
        if(sum>=arr[i]) pick=helper(i-1,sum-arr[i],arr);
        boolean notpick=helper(i-1,sum,arr);
        return pick||notpick;
    }
}
