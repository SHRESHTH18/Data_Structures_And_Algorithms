package step7_Recursion.Lec2_Subsequence_Pattern;
import java.util.*;
public class p5_combination_sum_1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(0,target,candidates,list,ans);
        return ans;
    }
    public void helper(int index,int target, int[] arr ,List<Integer> list , List<List<Integer>> ans){
        if(index==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(arr[index]<=target){
            list.add(arr[index]);
            helper(index,target-arr[index],arr,list,ans);
            list.remove(list.size()-1);
        }
        helper(index+1,target,arr,list,ans);

    }
}
