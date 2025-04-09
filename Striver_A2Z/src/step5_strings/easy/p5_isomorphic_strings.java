package step5_strings.easy;

import java.util.Scanner;
import java.util.*;
public class p5_isomorphic_strings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter string");
        String s= in.nextLine();
        System.out.println("enter string");
        String t=in.nextLine();
        boolean ans=isIsomorphic(s,t);
        System.out.println(ans);
    }
    public static boolean isIsomorphic(String s,String t){
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            // Compare the last seen positions
            if (mapS[cs] != mapT[ct]) return false;

            // Mark the current position (i+1 to avoid default 0)
            mapS[cs] = i + 1;
            mapT[ct] = i + 1;
        }

        return true;
    }

    //13 ms
//    public static boolean isIsomorphic(String s,String t){
//        HashSet<Character> ss= new HashSet<>();
//        HashSet<Character> tt= new HashSet<>();
//        int n=s.length();
//        int m=t.length();
//        if(n!=m) return false;
//        for(int i=0;i<n;i++){
//            ss.add(s.charAt(i));
//            tt.add(t.charAt(i));
//        }
//        if(ss.size()!=tt.size()) return false;
//        HashMap<Character,Character> map=new HashMap<>();
//        for(int i=0;i<n;i++){
//            if(map.containsKey(s.charAt(i)))
//                if(map.get(s.charAt(i))!=t.charAt(i))
//                    return false;
//            map.put(s.charAt(i),t.charAt(i));
//
//        }
//        return true;
//    }


}
