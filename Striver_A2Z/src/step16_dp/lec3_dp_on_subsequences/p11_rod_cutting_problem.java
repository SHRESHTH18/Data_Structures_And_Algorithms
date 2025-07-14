package step16_dp.lec3_dp_on_subsequences;
import java.util.*;
public class p11_rod_cutting_problem {
    public int cutRodTabulation(int[] price){
        int n=price.length;
        int[][] dp= new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            dp[1][i]=i*price[0];
        }

        for(int i=2;i<=n;i++){
            for(int len=1;len<=n;len++){
                int notTake=0+dp[i-1][len];
                int take=0;
                if(len>=i) take=price[i-1]+dp[i][len-i];
                dp[i][len]=Math.max(take,notTake);
            }
        }
        return dp[n][n];
    }

    public int cutRodMemoization(int[] price) {
        // code here
        int n=price.length;
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n,n,price,dp);
    }
    public int helper(int i,int len,int[] price,int[][] dp){
        //1-indexed
        if(i==1){
            return len*price[i-1];
        }
        if(dp[i][len]!=-1) return dp[i][len];
        int notTake=0+helper(i-1,len,price,dp);
        int take=0;
        if(len>=i) take=price[i-1]+helper(i,len-i,price,dp);
        return dp[i][len]=Math.max(take,notTake);
    }
    public int cutRod(int[] price) {
        // code here
        int n=price.length;
        return helper(n,n,price);
    }
    public int helper(int i,int len,int[] price){
        //1-indexed
        if(i==1){
            return len*price[i-1];
        }
        int notTake=0+helper(i-1,len,price);
        int take=0;
        if(len>=i) take=price[i-1]+helper(i,len-i,price);
        return Math.max(take,notTake);
    }
}
