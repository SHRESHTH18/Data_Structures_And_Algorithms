package step5_strings.easy;
import java.util.*;
public class p1_remove_outermost_parenthesis {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter string");
        String s= in.nextLine();
        String ans=removeOuterParentheses(s);
        System.out.println(ans);
    }

    //optimal solution
    public static String removeOuterParentheses(String s){
        StringBuilder result = new StringBuilder();
        int level = 0;
        for (char c : s.toCharArray()) {
            // If it's a closing parenthesis, decrease level first.
            if (c == ')') {
                level--;
            }
            // Only append if we are inside a nested level (not the outermost).
            if (level >= 1) {
                result.append(c);
            }
            // If it's an opening parenthesis, increase level after processing.
            if (c == '(') {
                level++;
            }
        }
        return result.toString();
    }
//    public static String removeOuterParentheses(String s){
//        int n = s.length();
//        String ans="";
//        int count1=0;
//        int count2=0;
//        for(int i=0;i<n;i++){
//            if(s.charAt(i)=='('){
//                count1++;
//                if(count1==1){
//                    continue;
//                }
//                ans=ans+'(';
//            }
//            else{
//                count2++;
//                if(count1==count2){
//                    count1=0;
//                    count2=0;
//                    continue;
//                }
//                ans=ans+')';
//            }
//        }
//        return ans;
//    }
}
