package step7_Recursion.Lec2_Subsequence_Pattern;
import java.util.*;
public class p8_subset_2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(int level, int[] nums,List<Integer> list,List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i=level;i<nums.length;i++){
            if(i>level && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            helper(i+1,nums,list,ans);
            list.remove(list.size()-1);
        }
    }
}
