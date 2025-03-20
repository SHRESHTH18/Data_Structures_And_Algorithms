package step3_Arrays.lec2_Medium;
import java.util.Scanner;

public class p4_max_subarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int a= maxSubArray(arr);
        System.out.println(a);
    }


    //also O(n) but concise version
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0;i< nums.length;i++){
            currSum = Math.max(currSum+nums[i],nums[i]);
            maxSum = Math.max(currSum,maxSum);
        }

        return maxSum;
    }


    //O(n)
//    public static int maxSubArray(int[] nums){
//        int max=nums[0];
//        int sum=0;
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]<0 && -nums[i]>sum){
//                sum=0;
//                if(nums[i]>max){
//                    max=nums[i];
//                }
//            }
//            else if(nums[i]<0 && -nums[i]<sum){
//                sum+=nums[i];
//            }
//            else{
//                sum+=nums[i];
//                if(sum>max){
//                    max=sum;
//                }
//            }
//        }
//        return max;
//    }
}
