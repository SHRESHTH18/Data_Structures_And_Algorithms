package step7_Recursion.Lec2_Subsequence_Pattern;
import java.util.*;
public class p10_letter_combination_of_phone_Number {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length()==0) return result;
        HashMap<Character,String> map = new HashMap<>();
        map.put('0',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        backtrack(digits, 0, new StringBuilder(),map, result);
        return result;
    }

    private void backtrack(String digits, int idx, StringBuilder sb, HashMap<Character,String> map,List<String> result) {
        if(digits.length() == sb.length()){
            result.add(sb.toString());
        }

        for(int i = idx; i<digits.length();i++){
            char num = digits.charAt(i);
            String val = map.get(num);

            for(char c: val.toCharArray()){
                backtrack(digits, i+1, sb.append(c),map, result);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

//    public List<String> letterCombinations(String digits) {
//        if (digits == null || digits.length() == 0) return new ArrayList<>();
//
//        HashMap<Character, String> keypadMap = new HashMap<>();
//        keypadMap.put('2', "abc");
//        keypadMap.put('3', "def");
//        keypadMap.put('4', "ghi");
//        keypadMap.put('5', "jkl");
//        keypadMap.put('6', "mno");
//        keypadMap.put('7', "pqrs");
//        keypadMap.put('8', "tuv");
//        keypadMap.put('9', "wxyz");
//
//        List<String> list = new ArrayList<>();
//        helper(0, digits, list, "", keypadMap);
//        return list;
//    }
//
//    public void helper(int index, String digits, List<String> list, String str, HashMap<Character, String> map) {
//        if (index == digits.length()) {
//            list.add(str);
//            return;
//        }
//
//        String letters = map.get(digits.charAt(index));
//        for (int i = 0; i < letters.length(); i++) {
//            helper(index + 1, digits, list, str + letters.charAt(i), map);
//        }
//    }
}
