package step16_dp.lec4_DP_on_strings;
import java.util.*;
public class p9_edit_distance {


    public int minDistanceTabulation(String word1, String word2) {
        int n=word1.length();
        int m= word2.length();
        int[][] dp =new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=j;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=0+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.min(
                            1+dp[i][j-1],//insert
                            Math.min(
                                    1+dp[i-1][j],//delete
                                    1+dp[i-1][j-1]//replace
                            )
                    );
                }
            }
        }
        return dp[n][m];
    }
    public int minDistanceMemo(String word1, String word2) {
        int n=word1.length();
        int m= word2.length();
        int[][] dp =new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n-1,m-1,word1,word2,dp);
    }
    public int helper(int i,int j,String s1,String s2,int[][] dp){
        if(i<0){
            return j+1;//return length of s2(all will be inserted)
        }
        if(j<0){
            return i+1;//return length of s1 (all will be deleted)
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=0+helper(i-1,j-1,s1,s2,dp);
        }
        else{
            return dp[i][j]=Math.min(
                    1+helper(i,j-1,s1,s2,dp),//insert
                    Math.min(
                            1+helper(i-1,j,s1,s2,dp),//delete
                            1+helper(i-1,j-1,s1,s2,dp)//replace
                    )
            );
        }
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m= word2.length();
        return helper(n-1,m-1,word1,word2);
    }
    public int helper(int i,int j,String s1,String s2){
        if(i<0){
            return j+1;//return length of s2(all will be inserted)
        }
        if(j<0){
            return i+1;//return length of s1 (all will be deleted)
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return 0+helper(i-1,j-1,s1,s2);
        }
        else{
            return Math.min(
                    1+helper(i,j-1,s1,s2),//insert
                    Math.min(
                            1+helper(i-1,j,s1,s2),//delete
                            1+helper(i-1,j-1,s1,s2)//replace
                    )
            );
        }
    }
}
