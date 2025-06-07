package step7_Recursion.Lec3_hard;
import java.util.*;
public class p1_palindrome_partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(s,0,list,ans);
        return ans;
    }
    public void helper(String s , int index , List<String> list ,List<List<String>> ans ){
        if(index==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i= index;i<s.length();i++){
            if(isPalindrome(s.substring(index,i+1))){
                list.add(s.substring(index,i+1));
                helper(s,i+1,list,ans);
                list.remove(list.size()-1);
            }
        }


    }


    public boolean isPalindrome(String s){
        int n=s.length();
        for(int i=0 ; i<n/2 ; i++){
            if(s.charAt(i)!=s.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
}
