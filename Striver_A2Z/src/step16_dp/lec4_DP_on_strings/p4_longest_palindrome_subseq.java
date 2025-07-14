package step16_dp.lec4_DP_on_strings;
import java.util.*;
public class p4_longest_palindrome_subseq {

    public int longestPalinSubseqUsingLCS(String s) {
        // code here
        int n=s.length();
        String rev=new StringBuilder(s).reverse().toString();
        return longestCommonSubseq(s,rev);
    }
    public int longestCommonSubseq(String s1,String s2){
        int n=s1.length();
        int m = s2.length();
        int[][] dp= new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n-1,m-1,s1,s2,dp);
    }
    public int helper(int i,int j , String s1,String s2,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+helper(i-1,j-1,s1,s2,dp);
        }
        return dp[i][j]=Math.max(helper(i-1,j,s1,s2,dp),helper(i,j-1,s1,s2,dp));
    }
    //tle
    public int longestPalinSubseq(String s) {
        // code here
        int n=s.length();
        StringBuilder sb= new StringBuilder();
        return helper(n-1,sb,s);
    }

    public int helper(int i,StringBuilder sb,String s){
        if(i==-1){
            if(isPalindrome(sb.toString())){
                return sb.length();
            }
            else return 0;
        }
        sb.append(s.charAt(i));
        int pick=helper(i-1,sb,s);
        sb.deleteCharAt(sb.length()-1);
        int notpick=helper(i-1,sb,s);
        return Math.max(pick,notpick);
    }

    public boolean isPalindrome(String s){
        int n=s.length();
        int i=0;
        while(i<n/2){
            if(s.charAt(i)!=s.charAt(n-1-i)) return false;
            i++;
        }
        return true;
    }
}
