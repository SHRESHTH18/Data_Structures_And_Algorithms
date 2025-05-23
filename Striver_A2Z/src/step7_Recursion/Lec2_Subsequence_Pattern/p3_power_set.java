package step7_Recursion.Lec2_Subsequence_Pattern;
import java.util.*;
public class p3_power_set {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(0,nums);
        return ans;
    }
    public void helper(int level , int[] nums){
        if(level==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        helper(level+1,nums);
        list.add(nums[level]);
        helper(level+1,nums);
        list.remove(list.size()-1);
    }
}
