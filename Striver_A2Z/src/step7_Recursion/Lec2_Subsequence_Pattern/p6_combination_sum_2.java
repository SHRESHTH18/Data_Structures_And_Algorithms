package step7_Recursion.Lec2_Subsequence_Pattern;
import java.util.*;
public class p6_combination_sum_2 {

    //not a binary recursion tree - instead a tree with multiple children allowed
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(0,target,candidates,list,ans);
        return ans;
    }
    public void helper(int index, int target , int[] arr , List<Integer> list, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i= index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]) continue;
            if(arr[i]>target){
                break;
            }
            list.add(arr[i]);
            helper(i+1,target-arr[i],arr,list,ans);
            list.remove(list.size()-1);
        }
    }

    /*
    brute - in combination sum 1 make some changes
    first of all we dont take an element multiple times therefore in recursion call we always give index+1
    secondly we use hashset for final answer to prevent duplicates
    eg - candidates=[1,1,1] , target =2
    it can be formed using [[1,1],[1,1],[1,1]] indexes being [[0,1],[1,2],[0,2]] but they are all the same i.e. [1,1]

    */
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        HashSet<List<Integer>> ans = new HashSet<>();
//        List<Integer> list = new ArrayList<>();
//        helper(0,target,candidates,list,ans);
//        return new ArrayList<>(ans);
//    }
//    public void helper(int index, int target , int[] arr , List<Integer> list, HashSet<List<Integer>> ans){
//        if(index==arr.length){
//            if(target==0){
//                ans.add(new ArrayList<>(list));
//            }
//            return;
//        }
//        if(arr[index]<=target){
//            list.add(arr[index]);
//            helper(index+1,target-arr[index],arr,list,ans);
//            list.remove(list.size()-1);
//        }
//        helper(index+1,target,arr,list,ans);
//    }
}
