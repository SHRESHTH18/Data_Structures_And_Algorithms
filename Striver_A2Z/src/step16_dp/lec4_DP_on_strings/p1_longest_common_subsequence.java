package step16_dp.lec4_DP_on_strings;
import java.util.*;
public class p1_longest_common_subsequence {
    public int longestCommonSubsequenceTabulation(String text1, String text2) {
        int n= text1.length();
        int m= text2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
    public int longestCommonSubsequenceMemoization(String text1, String text2) {
        int n= text1.length();
        int m= text2.length();
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n-1,m-1,text1,text2,dp);
    }
    public int helper(int i,int j,String a,String b,int[][] dp){
        if(i<0||j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)) return dp[i][j]=1+helper(i-1,j-1,a,b,dp);
        return dp[i][j]=Math.max(helper(i-1,j,a,b,dp),helper(i,j-1,a,b,dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n= text1.length();
        int m= text2.length();
        return helper(n-1,m-1,text1,text2);
    }
    public int helper(int i,int j,String a,String b){
        if(i<0||j<0) return 0;
        if(a.charAt(i)==b.charAt(j)) return 1+helper(i-1,j-1,a,b);
        return Math.max(helper(i-1,j,a,b),helper(i,j-1,a,b));
    }
}
