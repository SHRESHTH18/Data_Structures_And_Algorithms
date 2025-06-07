package step7_Recursion.Lec2_Subsequence_Pattern;
import java.util.*;

public class p7_subset_sum_1 {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        Arrays.sort(arr);
        ArrayList<Integer> ans= new ArrayList<>();
        helper(0,0,arr,ans);
        return ans;
    }
    public void helper(int index,int sum,int[] arr , ArrayList<Integer> ans){
        if(index==arr.length){
            ans.add(sum);
            return;
        }
        helper(index+1,sum,arr,ans);
        helper(index+1,sum+arr[index],arr,ans);
    }
}
