package step16_dp.lec3_dp_on_subsequences;
import java.util.*;
public class p2_partition_equal_subset_sum {
    public boolean canPartition_using_subset_sum(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;
        return isSubsetSumTabulation(nums,sum/2);
    }

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

    public boolean canPartitionMemoisation(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int[][][] dp=new int[n][sum+1][sum+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=sum;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(n-1,0,0,nums,dp);
    }
    public boolean helper(int i,int sum1,int sum2,int[] nums,int[][][] dp){
        if(i==0) return Math.abs(sum1-sum2)==nums[0];
        if(dp[i][sum1][sum2]!=-1){
            return dp[i][sum1][sum2]==1?true:false;
        }
        boolean take1=helper(i-1,sum1+nums[i],sum2,nums,dp);
        boolean take2=helper(i-1,sum1,sum2+nums[i],nums,dp);
        dp[i][sum1][sum2]=take1||take2?1:0;
        return take1||take2;
    }

    public boolean canPartition(int[] nums) {
        int n=nums.length;
        return helper(n-1,0,0,nums);
    }
    public boolean helper(int i,int sum1,int sum2,int[] nums){
        if(i==0) return Math.abs(sum1-sum2)==nums[0];
        boolean take1=helper(i-1,sum1+nums[i],sum2,nums);
        boolean take2=helper(i-1,sum1,sum2+nums[i],nums);
        return take1||take2;
    }
}
