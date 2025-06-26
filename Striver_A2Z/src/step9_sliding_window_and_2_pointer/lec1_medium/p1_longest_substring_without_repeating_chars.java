package step9_sliding_window_and_2_pointer.lec1_medium;
import java.util.*;
public class p1_longest_substring_without_repeating_chars {


    //better
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        HashSet<Character> set = new HashSet<>();
        int i=0;
        int j=0;
        int count=0;
        int n= s.length();
        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                count++;

                max=Math.max(count,max);
                set.add(s.charAt(j));
                j++;
            }
            else{
                set.remove(s.charAt(i));
                i++;
                count--;
            }

        }
        return max;
    }

    // brute
//    public int lengthOfLongestSubstring(String s) {
//        int max=0;
//        for(int i=0;i<s.length();i++){
//            HashSet<Character> set = new HashSet<>();
//            int count=0;
//            for(int j=i;j<s.length();j++){
//                if(!set.contains(s.charAt(j))){
//                    count++;
//                    max=Math.max(max,count);
//                }
//                else{
//                    break;
//                }
//                set.add(s.charAt(j));
//            }
//        }
//        return max;
//    }
}
