package step16_dp.lec3_dp_on_subsequences;
import java.util.*;
public class p8_target_sum {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int total=0;
        for(int i=0;i<n;i++) total+=nums[i];
        int sum=0;
        if((total + target)%2==1 || total+target < -1) return 0;
        else sum=(total+target)/2;
        int[][] dp=new int[n][sum+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n-1,sum,nums,dp);
    }
    public int helper(int i, int sum,int[] nums,int[][] dp){
        if(i==0){
            if(sum==0 && nums[0]==0) return 2;
            if(sum==0 || sum==nums[0]) return 1;
            return 0;
        }
        if(dp[i][sum]!=-1) return dp[i][sum];
        int pick =0;
        if(sum>=nums[i]) pick = helper(i-1,sum-nums[i],nums,dp);
        int notpick=helper(i-1,sum,nums,dp);

        return dp[i][sum]=pick+notpick;
    }
}
