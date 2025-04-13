package step5_strings.medium;

import java.util.HashMap;
import java.util.Scanner;

public class p5_substring_with_k_distinct {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter string");
        String s= in.nextLine();
        System.out.println("enter k");
        int k=in.nextInt();
        int ans=countSubstr(s,k);
        System.out.println(ans);
    }
    public static int countSubstr(String s,int k){
        return 0;
    }
    //O(n^2) - TLE
//    public static int countSubstr(String s , int k){
//        int ans=0;
//        int n = s.length();
//        for(int i=0;i<n;i++){
//            int[] count = new int[26];
//            int distinct=0;
//            for(int j=i;j<n;j++){
//                if(count[s.charAt(j)-'a']==0) distinct++;
//                count[s.charAt(j)-'a'] ++;
//                if(distinct==k){
//                    ans++;
//                }
//                else if(distinct>k){
//                    break;
//                }
//            }
//        }
//        return ans;
//    }
    //brute force
//    public static int countSubstr(String s , int k){
//        int count=0;
//        int n=s.length();
//        for(int i=0;i<n;i++){
//            for(int j=i;j<n;j++){
//                HashMap<Character,Integer> map=new HashMap<>();
//                for(int l=i;l<=j;l++){
//                    map.put(s.charAt(l),map.getOrDefault(map.get(s.charAt(l)),0)+1);
//                }
//                if(map.size()==k) count++;
//            }
//        }
//        return count;
//    }
}
