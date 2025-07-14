package step16_dp.lec2_1d_DP;
import java.util.*;
public class p4_house_robber_1 {
    //tabulation
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp= new int[n];
        Arrays.fill(dp,-1);
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>=2){
                pick=nums[i]+dp[i-2];
            }
            int not_pick=dp[i-1];

            dp[i]=Math.max(pick,not_pick);
        }
        return dp[n-1];

    }
    //memoisation
//    public int rob(int[] nums) {
//        int n=nums.length;
//        int[] dp= new int[n];
//        Arrays.fill(dp,-1);
//        return f(n-1,nums,dp);
//
//    }
//    public int f(int i,int[] nums,int[] dp){
//        if(i==0) return nums[i];
//        if(i<0) return 0;
//        if(dp[i]!=-1) return dp[i];
//        int pick = nums[i] + f(i-2,nums,dp);
//        int not_pick=0+f(i-1,nums,dp);
//        return dp[i]=Math.max(pick,not_pick);
//    }


    //basic recursion - TLE
//    public int rob(int[] nums) {
//        int n=nums.length;
//        boolean[] vis= new boolean[n];
//
//        return f(0,0,vis,nums);
//    }
//    public int f(int i,int sum ,boolean[] vis,int[] nums){
//        if(i==nums.length) return sum;
//        int no=f(i+1,sum,vis,nums);
//        int yes=0;
//        if(i==0 || vis[i-1]==false){
//            vis[i]=true;
//            yes=f(i+1,sum+nums[i],vis,nums);
//            vis[i]=false;
//        }
//
//        return Math.max(no,yes);
//    }
}
