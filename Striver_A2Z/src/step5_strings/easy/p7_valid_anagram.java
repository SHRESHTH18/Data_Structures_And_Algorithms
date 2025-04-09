package step5_strings.easy;

import java.util.Scanner;
import java.util.Arrays;
public class p7_valid_anagram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter string");
        String s= in.nextLine();
        System.out.println("enter string");
        String t=in.nextLine();
        boolean ans=isAnagram(s,t);
        System.out.println(ans);
    }
    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length()) return false;

        // HashMap<Character, Integer> map = new HashMap<>();
        // HashMap<Character, Integer> map1 = new HashMap<>();

        // for (int i = 0; i < s.length(); i++) {
        //     map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        //     map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) + 1);
        // }

        // return map.equals(map1);
        char[] chars = t.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);

        char[] chars1 = s.toCharArray();
        Arrays.sort(chars1);
        String key2 = new String(chars1);

        if(key.equals(key2)){
            return true;
        }
        else{
            return false;
        }
    }
//    public static boolean isAnagram(String s, String t){
//        if (s.equals(t)) {
//            return true;
//        }
//
//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        int charCount[] = new int[26];
//        for (char c : s.toCharArray()) {
//            charCount[c-'a']++;
//        }
//
//        for (char c : t.toCharArray()) {
//            charCount[c-'a']--;
//            if (charCount[c-'a'] < 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }
    //using hash arrays - 3ms
//    public static boolean isAnagram(String s,String t){
//        int n=s.length();
//        int m=t.length();
//        if(n!=m) return false;
//        int hash_s[] = new int[256];
//        int hash_t[]= new int[256];
//        for(int i=0;i<n;i++){
//            hash_s[s.charAt(i)]++;
//            hash_t[t.charAt(i)]++;
//        }
//        for(int i=0;i<256;i++){
//            if(hash_s[i]!=hash_t[i]) return false;
//        }
//        return true;
//    }
}
