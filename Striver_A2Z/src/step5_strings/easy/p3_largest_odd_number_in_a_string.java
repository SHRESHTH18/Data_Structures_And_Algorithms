package step5_strings.easy;

import java.util.Scanner;

public class p3_largest_odd_number_in_a_string {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter string");
        String s= in.nextLine();
        String ans=largesOddNumber(s);
        System.out.println(ans);
    }
    public static String largesOddNumber(String num){
        int n=num.length();
        for(int i=n-1;i>=0;i--){
            if((int)num.charAt(i)%2 !=0){
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}
