package step16_dp.lec2_1d_DP;
import java.util.*;
public class p2_frog_jump {
    int minCost(int[] height) {
        // code here
        int n=height.length;
        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);
        int cost=helper(n-1,height,dp);
        return cost;

    }
    public int helper(int ind,int[] height,int[] dp){
        if(ind==0)return 0;
        if(dp[ind]!=-1) return dp[ind];

        int left=helper(ind-1,height,dp)+Math.abs(height[ind]-height[ind-1]);
        int right=Integer.MAX_VALUE;
        if(ind>1){
            right=helper(ind-2,height,dp)+Math.abs(height[ind]-height[ind-2]);
        }
        return dp[ind]=Math.min(left,right);
    }
}
