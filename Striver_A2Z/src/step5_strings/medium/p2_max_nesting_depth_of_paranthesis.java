package step5_strings.medium;

import java.util.Scanner;

public class p2_max_nesting_depth_of_paranthesis {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter string");
        String s= in.nextLine();
        int ans=maxDepth(s);
        System.out.println(ans);
    }
    public static int maxDepth(String s){
        int level=0;
        int maxLevel=0;
        int n= s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                level++;
                maxLevel=Math.max(maxLevel,level);
            }
            else if(s.charAt(i)==')'){
                level--;
            }
        }
        return maxLevel;
    }
}
