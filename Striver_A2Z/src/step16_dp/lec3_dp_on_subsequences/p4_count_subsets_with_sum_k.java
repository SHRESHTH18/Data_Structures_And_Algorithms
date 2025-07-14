package step16_dp.lec3_dp_on_subsequences;
import java.util.*;
public class p4_count_subsets_with_sum_k {
    public int perfectSumTabulation(int[] nums, int target) {
        // code here
        int n = nums.length;
        int totalSum=0;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }
        int[][] dp = new int[n][totalSum + 1];

        // Initialize
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1; // There's always 1 subset (empty set) for target 0
        }

        dp[0][0] = (nums[0] == 0) ? 2 : 1;

        if (nums[0] != 0 && nums[0] <= target) {
            dp[0][nums[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                int notTake = dp[i - 1][t];
                int take = 0;
                if (t >= nums[i]) {
                    take = dp[i - 1][t - nums[i]];
                }
                dp[i][t] = take + notTake;
            }
        }

        return dp[n - 1][target];
    }
    public int perfectSumMemoization(int[] nums, int target) {
        // code here
        int n=nums.length;
        int[][] dp=new int[n][target+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n-1,target,nums,dp);
    }
    public int helper(int i, int target,int[] nums,int[][] dp){
        if(target==0) return 1;
        if(i==0){
            if(target==nums[0]) return 1;
            else return 0;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int take=0;
        if(target>=nums[i]) take=helper(i-1,target-nums[i],nums,dp);
        int notTake=helper(i-1,target,nums,dp);
        return dp[i][target]=take+notTake;
    }
    public int perfectSum(int[] nums, int target) {
        // code here
        int n=nums.length;
        return helper(n-1,target,nums);
    }
    public int helper(int i, int target,int[] nums){
        if(i==-1){
            if(target==0) return 1;
            else return 0;
        }
        int take=0;
        if(target>=nums[i]) take=helper(i-1,target-nums[i],nums);
        int notTake=helper(i-1,target,nums);
        return take+notTake;
    }
}
