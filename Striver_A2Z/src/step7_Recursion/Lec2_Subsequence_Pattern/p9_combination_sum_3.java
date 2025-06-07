package step7_Recursion.Lec2_Subsequence_Pattern;
import java.util.*;
public class p9_combination_sum_3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[9];
        for(int i=1;i<=9;i++){
            arr[i-1]=i;
        }
        helper(0,0,0,k,n,arr,list,ans);
        return ans;
    }
    public void helper(int index , int count ,int sum,int k,int n,int[] arr , List<Integer> list , List<List<Integer>> ans){
        if(count == k){
            if(sum==n){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(index==arr.length) return;
        helper(index+1,count,sum,k,n,arr,list,ans);
        list.add(arr[index]);
        helper(index+1,count+1,sum+arr[index],k,n,arr,list,ans);
        list.remove(list.size()-1);
    }
}
