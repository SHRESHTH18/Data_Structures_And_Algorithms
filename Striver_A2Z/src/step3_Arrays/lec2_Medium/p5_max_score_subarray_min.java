package step3_Arrays.lec2_Medium;

import java.util.Scanner;

public class p5_max_score_subarray_min {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int a= pairWithMaxSum(arr);
        System.out.println(a);
    }

    //max sum of 2 smalles elements of an subarray can be only from a subarray of 2;
    public static int pairWithMaxSum(int[] nums){
        int sum=0;
        int max=nums[0]+nums[1];
        for(int i=1;i<nums.length-1;i++){
            sum=nums[i]+nums[i+1];
            max=Math.max(sum,max);
        }
        return max;
    }
}
