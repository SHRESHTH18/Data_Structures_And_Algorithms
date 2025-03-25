package step3_Arrays.lec2_Medium;

import java.util.Arrays;
import java.util.Scanner;
//approach
/*
find the index from where the array is truly decreasing . Set it to start
now from start till end of sub array search for the least element that is greater than element at nums[start-1]
now we swap this element with element nums[start]-1
and then sort the sub array from start till nums.length-1
 */

public class p8_next_permutation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n = in.nextInt();
        int [] nums = new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums){
        int start=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                start=i+1;
            }
        }
        if (start != 0) {
            //least element from decreasing subarray which is greater than element at start-1
            int min_idx=nums.length-1;
            for(int j=start;j<nums.length;j++){
                if(nums[j]>nums[start-1]){
                    min_idx=j;
                }
            }
            swap(nums,start-1,min_idx);
            Arrays.sort(nums,start,nums.length); //nums.length excluded
        }
        else {
            Arrays.sort(nums);
        }
    }
//    //doesnt work for cases like 132 - o/p 312 but correct output is 213
//    public static void nextPermutation(int[] nums){
//        for(int i=nums.length-1;i>0;i--){
//            if(nums[i]>nums[i-1]){
//                swap(nums,i,i-1);
//                return;
//            }
//        }
//        Arrays.sort(nums);
//    }
    public static void swap(int [] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
