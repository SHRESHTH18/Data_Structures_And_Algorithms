package step7_Recursion.Lec3_hard;
import java.util.*;
public class p8_expression_add_operators {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            }
            else{
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);

                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);

                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }


//    //cannot handle 2 or more digit numbers
//    //only good for 1+2+# or 1*2*3
//    //cannot handle 12+3
//    public List<String> addOperators(String num, int target) {
//        if(num.length()==0){
//            return new ArrayList<String>();
//        }
//        StringBuilder sb = new StringBuilder(num);
//        List<String> ans= new ArrayList<>();
//        helper(1,sb,target,ans,num.length());
//        return ans;
//    }
//    public void helper(int index,StringBuilder sb,int target, List<String> ans,int len){
//        if(index==sb.length()){
//            if(calculate(sb.toString())==target){
//                ans.add(sb.toString());
//            }
//            return;
//        }
//
//        sb.insert(index,'+');
//        helper(index+2,sb,target,ans,len);
//        sb.delete(index,index+1);
//        sb.insert(index,'*');
//        helper(index+2,sb,target,ans,len);
//        sb.delete(index,index+1);
//        sb.insert(index,'-');
//        helper(index+2,sb,target,ans,len);
//        sb.delete(index,index+1);
//    }
//
//    public int calculate(String s){
//        Stack<Integer> stack = new Stack<>();
//        for(int i =0;i<s.length();i++){
//            if(s.charAt(i)=='*'){
//                stack.push(stack.pop() * (s.charAt(i+1)-'0'));
//                i++;
//            }
//            else if(s.charAt(i)=='-'){
//                stack.push(-(s.charAt(i+1)-'0'));
//                i++;
//            }
//            else if(s.charAt(i)=='+'){
//                continue;
//            }
//            else{
//                stack.push(s.charAt(i)-'0');
//            }
//        }
//        int result=0;
//        for(int val:stack){
//            result+=val;
//        }
//        return result;
//    }
}
