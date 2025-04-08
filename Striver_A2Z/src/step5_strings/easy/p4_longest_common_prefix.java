package step5_strings.easy;
import java.util.*;

public class p4_longest_common_prefix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n = in.nextInt();
        System.out.println("enter array");
        String arr[] = new String[n];
        for(int i = 0;i<n;i++){
            arr[i]=in.next();
        }
        System.out.println(longestCommonPrefix(arr));
    }
    public static String longestCommonPrefix(String [] strs){
        int min=Integer.MAX_VALUE;
        int n= strs.length;
        String s="";
        for(int i=0;i<n;i++){
            if(strs[i].length()<min){
                min=strs[i].length();
                s=strs[i];
            }
        }
        StringBuilder prefix = new StringBuilder();
        outer:
        for(int i=0;i<min;i++){
            for(int j=0;j<n;j++){
                if(strs[j].charAt(i) != s.charAt(i)){
                    break outer;
                }
            }
            prefix.append(s.charAt(i));
        }
        return prefix.toString();
    }
//    public static String longestCommonPrefix(String[] strs){
//        String prefix="";
//        prefix=strs[0];
//        int n=strs.length;
//        for(int i=1;i<n;i++){
//            int len=Math.min(strs[i].length(),prefix.length());
//            for(int j=0;j<len;j++){
//                if(prefix.charAt(j)!= strs[i].charAt(j)){
//                    prefix=prefix.substring(0,j);
//                    break;
//                }
//            }
//        }
//        return prefix;
//    }
}
