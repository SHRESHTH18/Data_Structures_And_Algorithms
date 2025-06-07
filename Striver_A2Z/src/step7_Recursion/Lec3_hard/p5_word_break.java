package step7_Recursion.Lec3_hard;
import java.util.*;
public class p5_word_break {

    //works fine but doesnt work for
    //s = "aaaaaaa"
    //wordDict =["aaaa","aaa"]

//    public boolean wordBreak(String s, List<String> wordDict) {
//        return helper(0,s,wordDict);
//    }
//    public boolean helper(int index,String s , List<String> wordDict){
//        if(index==s.length()){
//            return true;
//        }
//        for(int i=index;i<s.length();i++){
//            if(wordDict.contains(s.substring(index,i+1))){
//                return helper(i+1,s,wordDict);
//            }
//        }
//        return false;
//    }
}
