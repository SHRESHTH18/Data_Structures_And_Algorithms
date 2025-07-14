package step16_dp.lec2_1d_DP;
import java.util.*;

public class p1_climbing_stairs {
    class Solution {

        public int climbStairs(int n) {
            if(n<=1)
            {
                return 1;
            }
            int dp[] = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;
            for(int i=2;i<=n;i++)
            {
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];

        }

        //memoisation
//        public int climbStairs(int n) {
//            int[] dp =new int[n+1];
//            Arrays.fill(dp,-1);
//            return helper(0, n,dp);
//        }
//
//        public int helper(int curr, int n,int[] dp) {
//            if (curr > n) return 0;
//            if (curr == n) return 1;
//            if(dp[curr]!=-1) return dp[curr];
//            return dp[curr]=helper(curr + 1, n,dp) + helper(curr + 2, n,dp);
//        }
    }

//    public int climbStairs(int n) {
//        return helper(0, n);
//    }
//
//    public int helper(int curr, int n) {
//        if (curr > n) return 0;
//        if (curr == n) return 1;
//        return helper(curr + 1, n) + helper(curr + 2, n);
//    }

//    int count=0;
//    public int climbStairs(int n) {
//        helper(0,n);
//        return count;
//    }
//    public void helper(int curr,int n){
//        if(curr>n) return;
//        if(curr==n){
//            count++;
//            return;
//        }
//        helper(curr+1,n);
//        helper(curr+2,n);
//    }
}
