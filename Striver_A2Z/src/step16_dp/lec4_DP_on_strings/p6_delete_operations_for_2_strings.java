package step16_dp.lec4_DP_on_strings;
import java.util.*;
public class p6_delete_operations_for_2_strings {
    public int minDistance(String word1, String word2) {
        int lcs=lcs(word1,word2);
        return (word1.length()-lcs)+(word2.length()-lcs);
    }

    public int lcs(String s1,String s2){
        int n= s1.length();
        int m= s2.length();
        int[][] dp =new int [n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n-1,m-1,s1,s2,dp);
    }
    public int helper(int i, int j, String s1, String s2,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=1+helper(i-1,j-1,s1,s2,dp);

        return dp[i][j]=Math.max(helper(i-1,j,s1,s2,dp),helper(i,j-1,s1,s2,dp));
    }
}
