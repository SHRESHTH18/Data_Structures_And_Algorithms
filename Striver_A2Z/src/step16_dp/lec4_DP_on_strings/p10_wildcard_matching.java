package step16_dp.lec4_DP_on_strings;
import java.util.*;
public class p10_wildcard_matching {

    class Solution {
        public boolean isMatchMemo(String s, String p) {
            int n=s.length();
            int m=p.length();
            int[][] dp= new int [n][m];
            for(int i=0;i<n;i++){
                Arrays.fill(dp[i],-1);
            }
            return helper(n-1,m-1,s,p,dp);
        }
        public boolean helper(int i , int j, String s, String p,int[][] dp){
            if(i<0 && j<0) return true;
            else if(i<0){
                while(j>=0){
                    if(p.charAt(j--)!='*') return false;
                }
                return true;
            }
            if(j<0) return false;
            if(dp[i][j]!=-1) return dp[i][j]==1;
            if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
                dp[i][j]=(helper(i-1,j-1,s,p,dp))?1:0;
                return dp[i][j]==1;
            }
            else if(p.charAt(j)=='*'){
                dp[i][j]= (helper(i-1,j,s,p,dp) || helper(i,j-1,s,p,dp))?1:0;
                return dp[i][j]==1;
            }
            dp[i][j]=0;
            return false;
        }
    }
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        return helper(n-1,m-1,s,p);
    }
    public boolean helper(int i , int j, String s, String p){
        if(i<0 && j<0) return true;
        else if(i<0){
            while(j>=0){
                if(p.charAt(j--)!='*') return false;
            }
            return true;
        }
        if(j<0) return false;
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            return helper(i-1,j-1,s,p);
        }
        else if(p.charAt(j)=='*'){
            return  helper(i-1,j,s,p) || helper(i,j-1,s,p);
        }
        return false;
    }
}
