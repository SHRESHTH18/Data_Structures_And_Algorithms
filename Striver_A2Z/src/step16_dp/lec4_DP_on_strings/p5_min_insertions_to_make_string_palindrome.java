package step16_dp.lec4_DP_on_strings;
import java.util.*;
public class p5_min_insertions_to_make_string_palindrome {

    public int minInsertionsTab(String s) {
        return s.length()-longestPalindromeSubseq(s);
    }
    public int longestPalindromeSubseqTab(String s){
        String rev = new StringBuilder(s).reverse().toString();
        return longestCommonSubseq(s,rev);
    }
    public int longestCommonSubseqTab(String s, String rev){
        int n=s.length();
        int m=rev.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }

    public int minInsertions(String s) {
        return s.length()-longestPalindromeSubseq(s);
    }
    public int longestPalindromeSubseq(String s){
        String rev = new StringBuilder(s).reverse().toString();
        return longestCommonSubseq(s,rev);
    }
    public int longestCommonSubseq(String s, String rev){
        int n=s.length();
        int m=rev.length();
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n-1,m-1,s,rev,dp);
    }
    public int helper(int i, int j, String s, String rev,int[][] dp){
        if(i<0||j<0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==rev.charAt(j)){
            return dp[i][j]=1+helper(i-1,j-1,s,rev,dp);
        }
        return dp[i][j]=Math.max(helper(i-1,j,s,rev,dp),helper(i,j-1,s,rev,dp));
    }
}
