package step7_Recursion.Lec2_Subsequence_Pattern;

public class p4_subsequence_with_sum_k {


    //TLE
//    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
//        // code here
//        return helper(0,arr,K,0);
//    }
//    public static boolean helper(int index,int[] arr, int k , int sum){
//        if(index==arr.length){
//            return false;
//        }
//        if(sum==k){
//            return true;
//        }
//        boolean a = helper(index+1,arr,k,sum);
//        boolean b= helper(index+1,arr,k,sum+arr[index]);
//        return a||b;
//    }
}
