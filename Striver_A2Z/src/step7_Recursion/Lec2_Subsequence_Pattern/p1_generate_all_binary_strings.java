package step7_Recursion.Lec2_Subsequence_Pattern;
import java.util.ArrayList;
public class p1_generate_all_binary_strings {
    public static ArrayList<String> generateBinaryStrings(int n) {
        // code here
        ArrayList<String> list = new ArrayList<>();
        helper(n,"",'0',list);
        return list;
    }
    public static void helper(int n, String str, char lastChar,ArrayList<String> list){
        if(n==0){
            list.add(str);
            return;
        }
        helper(n-1,str+"0",'0',list);
        if(lastChar!='1'){
            helper(n-1,str+"1",'1',list);
        }
    }
}
