package step5_strings.easy;

import java.util.Scanner;
import java.util.*;
public class p2_reverse_words_in_a_string {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter string");
        String s= in.nextLine();
        String ans=reverseWords(s);
        System.out.println(ans);
    }
    public static String reverseWords(String s){
        ArrayList<String> list= new ArrayList<>();
        int n=s.length();
        char[] chr = s.toCharArray();
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<n;i++){

            if(chr[i]==' '){
                if(!sb.isEmpty()) {
                    list.add(sb.toString());
                    sb.setLength(0);
                }
            }
            else{
                sb.append(chr[i]);
            }
        }
        if(!sb.isEmpty()) list.add(sb.toString()); // to append last word
        StringBuilder ans = new StringBuilder();
        int m=list.size();
        for(int i=m-1;i>0;i--){
            ans.append(list.get(i));
            ans.append(" ");
        }
        ans.append(list.get(0));
        return ans.toString();
    }
}
