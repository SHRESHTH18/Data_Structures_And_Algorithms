package step5_strings.easy;

import java.util.Scanner;
import java.util.*;
public class p6_rotate_string {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter string");
        String s= in.nextLine();
        System.out.println("enter string");
        String t=in.nextLine();
        boolean ans=rotateString(s,t);
        System.out.println(ans);
    }

    public static boolean rotateString(String s,String goal){
        if (s.length() != goal.length()) return false;

        // Create a new string by concatenating 's' with itself
        String doubledString = s + s;

        // Use contains to search for 'goal' in 'doubledString'
        // If contains return true, 'goal' is a substring
        return doubledString.contains(goal);
    }

//    public static boolean rotateString(String s, String goal){
//        int flag=0;
//        int n= s.length();
//        int m=goal.length();
//        if(n!=m) return false;
//        for(int i=0;i<n;i++){//level of rotation
//            for(int k=0;k<n;k++){
//                if(s.charAt((i+k)%n) == goal.charAt(k)) flag=1;
//                else {
//                    flag=0;
//                    break;
//                }
//            }
//            if(flag==1) {
//                return true;
//            }
//        }
//        return false;
//    }
}
