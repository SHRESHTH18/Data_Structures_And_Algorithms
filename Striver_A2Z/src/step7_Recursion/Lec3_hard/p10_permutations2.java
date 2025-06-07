package step7_Recursion.Lec3_hard;
import java.util.*;
public class p10_permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> input = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            input.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans= new ArrayList<>();
        helper(input , list , ans );
        return ans;
    }
    public void helper(List<Integer> input , List<Integer> list , List<List<Integer>> ans){
        if(input.size()==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<input.size();i++){
            int element=input.get(i);
            if(i>0 && element==input.get(i-1)){
                continue;
            }
            input.remove(i);
            list.add(element);
            helper(input,list,ans);
            input.add(i,element);
            list.remove(list.size()-1);
        }
    }
}
