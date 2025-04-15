package step5_strings.medium;

import java.util.Scanner;

public class p6_longest_palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter string");
        String s= in.nextLine();
        String ans=longestPalindrome(s);
        System.out.println(ans);
    }

    public static String longestPalindrome(String s){
        return "";
    }

    //brute check for every possible substring , is it longest palindrome ?
//    public static String longestPalindrome(String s){
//        int n=s.length();
//        int max=1;
//        String longPal=String.valueOf(s.charAt(0));
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                if(isPalindrome(s.substring(i,j+1))){
//                    if(j-i+1 > max){
//                        max=j-i+1;
//                        longPal=s.substring(i,j+1);
//                    }
//                }
//            }
//        }
//        return longPal;
//    }
//    public static boolean isPalindrome(String s){
//        int n=s.length();
//        for(int i=0;i<n/2;i++){
//            if(s.charAt(i)!=s.charAt(n-i-1)){
//                return false;
//            }
//        }
//        return true;
//    }
}
