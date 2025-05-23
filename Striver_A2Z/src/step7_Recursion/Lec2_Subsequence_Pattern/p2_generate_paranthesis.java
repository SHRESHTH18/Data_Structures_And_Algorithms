package step7_Recursion.Lec2_Subsequence_Pattern;
import java.util.ArrayList;
public class p2_generate_paranthesis {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        helper(list,n,0,0,"");
        return list;
    }
    public void helper(ArrayList<String> list, int n , int num_open,int num_closed, String str){
        if(str.length()==n*2){
            list.add(str);
            return;
        }
        if(num_open<n){
            helper(list,n,num_open+1,num_closed,str+"(");
        }
        if(num_open>num_closed){
            helper(list,n,num_open,num_closed+1,str+")");
        }
    }
}
