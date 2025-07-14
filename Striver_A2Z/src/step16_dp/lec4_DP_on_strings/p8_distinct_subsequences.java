package step16_dp.lec4_DP_on_strings;
import java.util.*;
public class p8_distinct_subsequences {
    public int numDistinctSpaceOpt(String s, String t) {
        int n=s.length();
        int m= t.length();
        int[] prev=new int[m+1];
        prev[0]=1;
        for(int i=1;i<=n;i++){
            int[] curr = new int[m+1];
            curr[0]=1;
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    curr[j]=prev[j-1]+prev[j];
                }
                else{
                    curr[j]=prev[j];
                }
            }
            prev=curr;
        }
        return prev[m];
    }
    public int numDistinctTabulation(String s, String t) {
        int n=s.length();
        int m= t.length();
        int[][] dp= new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    public int numDistinctMemo(String s, String t) {
        int n=s.length();
        int m= t.length();
        int[][] dp= new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n-1,m-1,s,t,dp);
    }
    public int helper(int i, int j, String s , String t,int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int match =0;
        int not=0;
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=helper(i-1,j-1,s,t,dp)+helper(i-1,j,s,t,dp);
        }
        else{
            return dp[i][j]=helper(i-1,j,s,t,dp);
        }
    }

    //brute check all subsequences
    public int numDistinct(String s, String t) {
        int n=s.length();
        StringBuilder sb= new StringBuilder();
        return helper(0,sb,s,t);
    }
    public int helper(int i , StringBuilder sb,String s , String t){
        if((sb.length()==t.length())){
            if(sb.toString().equals(t)){
                return 1;
            }
            return 0;
        }
        if(i==s.length()) return 0;

        sb.append(s.charAt(i));
        int pick = helper(i+1,sb,s,t);
        sb.deleteCharAt(sb.length()-1);
        int not=helper(i+1,sb,s,t);
        return pick+not;

    }
}
