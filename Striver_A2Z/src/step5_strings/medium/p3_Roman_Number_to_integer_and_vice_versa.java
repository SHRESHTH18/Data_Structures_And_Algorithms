package step5_strings.medium;

import java.util.HashMap;
import java.util.Scanner;

public class p3_Roman_Number_to_integer_and_vice_versa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter string");
        String s= in.nextLine();
        int ans=romanToInt(s);
        System.out.println(ans);
    }
    public static int romanToInt(String s){
        int num=0;
        int n=s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        for(int i=0;i<n;i++){
            if(i<n-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                num-=map.get(s.charAt(i));
            }
            else{
                num+=map.get(s.charAt(i));
            }

        }
        return num;
    }
}
