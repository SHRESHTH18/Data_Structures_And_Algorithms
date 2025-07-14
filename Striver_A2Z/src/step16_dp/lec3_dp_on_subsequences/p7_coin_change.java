package step16_dp.lec3_dp_on_subsequences;
import java.util.*;
public class p7_coin_change {

    public int coinChangeTabulation(int[] coins,int amount){
        int n=coins.length;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,(int)1e8);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<n;j++){
                if(i>=coins[j]) dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);
            }
        }
        return dp[amount]==(int)1e8?-1:dp[amount];
    }
    public int coinChangeMemoization(int[] coins, int amount) {
        int n=coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        int min=helper(amount,coins,dp);
        return min==(int)1e8?-1:min;
    }
    public int helper(int amount, int[] coins,int[] dp){
        int n=coins.length;
        if(amount==0) return 0;
        if(dp[amount]!=-1) return dp[amount];
        int min=(int)1e8;
        for(int i=0;i<n;i++){
            if(amount>=coins[i]){
                min=Math.min(min,1+helper(amount-coins[i],coins,dp));
            }
        }
        return dp[amount]=min;
    }

    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int min=helper(amount,coins);
        return min==(int)1e8?-1:min;
    }
    public int helper(int amount, int[] coins){
        int n=coins.length;
        if(amount==0) return 0;
        int min=(int)1e8;
        for(int i=0;i<n;i++){
            if(amount>=coins[i]){
                min=Math.min(min,1+helper(amount-coins[i],coins));
            }
        }
        return min;
    }
    class Pair{
        int count;
        int amount;
        public Pair(int count,int amount){
            this.count=count;
            this.amount=amount;
        }
    }
    public int coinChangeBFS(int[] coins,int amount){
        int n=coins.length;
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(0,amount));
        while(!q.isEmpty()){
            Pair el = q.poll();
            int count=el.count;
            int amount1=el.amount;
            if(amount1==0) return count;
            if(amount1<0) continue;
            for(int i=0;i<n;i++){
                if(amount1>=coins[i]) q.offer(new Pair(count+1,amount1-coins[i]));
            }
        }
        return -1;
    }
}

