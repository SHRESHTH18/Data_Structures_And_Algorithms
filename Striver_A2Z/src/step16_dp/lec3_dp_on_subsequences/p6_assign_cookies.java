package step16_dp.lec3_dp_on_subsequences;
import java.util.*;
public class p6_assign_cookies {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
        int m=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        int count=0;
        while(i<n && j<m){
            if(s[j]>=g[i]){
                count++;
                j++;
                i++;
            }
            else j++;
        }
        return count;
    }
}
