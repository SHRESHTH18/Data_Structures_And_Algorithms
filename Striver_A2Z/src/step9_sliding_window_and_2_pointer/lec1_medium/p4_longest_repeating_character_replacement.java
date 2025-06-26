package step9_sliding_window_and_2_pointer.lec1_medium;
import java.util.*;
public class p4_longest_repeating_character_replacement {


    public int characterReplacement(String s, int k) {
        int len = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int max_freq=0;
        int max_len=0;
        int l=0;
        int r=0;
        while(r<len){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            max_freq=Math.max(max_freq,map.get(s.charAt(r)));
            if((r-l+1)-max_freq>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            max_len=Math.max(max_len,r-l+1);
            r++;
        }

        return max_len;
    }
//    public int characterReplacement(String s, int k) {
//        int len = s.length();
//        int max=0;
//        HashMap<Character,Integer> map = new HashMap<>();
//        int max_freq=0;
//        int max_len=0;
//        int l=0;
//        int r=0;
//        while(r<len){
//            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
//            max_freq=Math.max(max_freq,map.get(s.charAt(r)));
//            while((r-l+1)-max_freq>k){
//                map.put(s.charAt(l),map.get(s.charAt(l))-1);
//                max_freq=0;
//                for(Character key:map.keySet()){
//                    max_freq=Math.max(max_freq,map.get(key));
//                }
//                l++;
//            }
//            if((r-l+1)-max_freq<=k){
//                max_len=Math.max(max_len,r-l+1);
//            }
//            r++;
//        }
//
//        return max_len;
//    }
}
