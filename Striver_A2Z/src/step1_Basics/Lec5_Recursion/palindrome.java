package step1_Basics.Lec5_Recursion;
import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("enter string");
        String s = in.nextLine();
        System.out.println(isPalindrome(s));

    }
    //145 ms
    public static boolean isPalindrome(String s) {
        if(s.isBlank()){
            return true;
        }

        s=s.toLowerCase();
        int lens=s.length();
        String alphanumeric="abcdefghijklmnopqrstuvwxyz0123456789";

        String edit="";
        for(int i=0;i<lens;i++){

            for(char ch:alphanumeric.toCharArray()){
                if(ch==s.charAt(i)){
                    edit=edit.concat(ch+"");
                    break;
                }
            }
        }
        System.out.println(edit);
        int lenedit =edit.length();
        for (int i=0;i<lenedit/2;i++){
            if(edit.charAt(i)!=edit.charAt(lenedit-i-1)){
                return false;
            }
        }
        return true ;
    }


    //2ms
//    public static boolean isPalindrome(String s) {
//        if (s.isEmpty()) {
//            return true;
//        }
//        int start = 0;
//        int last = s.length() - 1;
//        while(start <= last) {
//            char currFirst = s.charAt(start);
//            char currLast = s.charAt(last);
//            if (!Character.isLetterOrDigit(currFirst )) {
//                start++;
//            } else if(!Character.isLetterOrDigit(currLast)) {
//                last--;
//            } else {
//                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
//                    return false;
//                }
//                start++;
//                last--;
//            }
//        }
//        return true;
//    }
}
