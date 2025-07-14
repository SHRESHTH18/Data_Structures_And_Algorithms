package step16_dp.lec3_dp_on_subsequences;
import java.util.*;
public class p9_coin_change_2 {
    class Solution {
        public int change(int amount, int[] coins) {
            int n=coins.length;
            int[][] dp= new int[n][amount+1];
            for(int i=0;i<n;i++){
                Arrays.fill(dp[i],-1);
            }
            return helper(n-1,amount,coins,dp);
        }
        public int helper(int i,int amount,int[] coins,int[][] dp){
            if(i==0){
                return amount%coins[0]==0? 1: 0;
            }
            if(dp[i][amount]!=-1) return dp[i][amount];
            int n=coins.length;
            int take=0;
            if(amount>=coins[i]) take=helper(i,amount-coins[i],coins,dp);
            int nottake=helper(i-1,amount,coins,dp);
            return dp[i][amount]=take+nottake;
        }
    }
}
