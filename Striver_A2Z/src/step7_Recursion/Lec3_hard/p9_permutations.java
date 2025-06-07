package step7_Recursion.Lec3_hard;
import java.util.*;
public class p9_permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> set = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        List<List<Integer>> ans= new ArrayList<>();;
        List<Integer> list= new ArrayList<>();
        helper(set,list,ans);
        return ans;
    }
    public void helper(List<Integer> set,List<Integer> list , List<List<Integer>> ans){
        if(set.size()==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<set.size();i++){
            int element= set.get(i);
            list.add(element);
            set.remove(i);
            helper(set,list,ans);
            set.add(i,element);
            list.remove(list.size()-1);
        }
    }
}
