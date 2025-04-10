package step5_strings.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p1_sort_characters_by_frequency {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter string");
        String s= in.nextLine();
        String ans=frequencySort(s);
        System.out.println(ans);
    }
    public static String frequencySort(String s){
        int n= s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i) , 0)+1);
        }
        int m=map.size();
        StringBuilder ans= new StringBuilder();
        for(int i=0;i<m;i++){
            int max =Integer.MIN_VALUE;
            char maxKey='0';
            for(Map.Entry<Character,Integer> pair:map.entrySet()){
                if(pair.getValue()>max){
                    max= pair.getValue();
                    maxKey=pair.getKey();
                }
            }
            for(int j=0;j<max;j++){
                ans.append(maxKey);
            }
            map.remove(maxKey);

        }
        return ans.toString();
    }
}
