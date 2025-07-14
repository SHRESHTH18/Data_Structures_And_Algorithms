package step16_dp.lec4_DP_on_strings;

public class p7_shortest_common_supersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n= str1.length();
        int m = str2.length();
        int[][] lcs= new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    lcs[i][j]=1+lcs[i-1][j-1];
                }
                else{
                    lcs[i][j]=Math.max(lcs[i-1][j],lcs[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i=n;
        int j=m;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;j--;
            }
            else{
                if(lcs[i][j-1]>=lcs[i-1][j]){
                    sb.append(str2.charAt(j-1));
                    j--;
                }
                else{
                    sb.append(str1.charAt(i-1));
                    i--;
                }
            }
        }
        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
}
