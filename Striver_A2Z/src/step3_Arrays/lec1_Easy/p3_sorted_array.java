package step3_Arrays.lec1_Easy;

import java.util.Scanner;

public class p3_sorted_array {
    public static void main(String[] args) {
        System.out.println("enter size of array");
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println(check(arr));
    }
    static boolean check(int[] nums) {
        int min_idx=min(nums);
        for(int i=min_idx;i<min_idx+nums.length-1;i++){
            if(nums[i%nums.length]>nums[(i+1)%nums.length]){
                if(nums[(i+1)%nums.length]==nums[min_idx] && nums[(i+1)%nums.length]==nums[(i+2)%nums.length]){
                    continue;
                }
                return false;
            }
        }
        return true;
    }
    static int min(int [] arr){
        int min=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[min]){
                min=i;
            }
        }
        return min;
    }
}


/*
class Solution {
    public boolean check(int[] nums) {
        int count =0;
        int n= nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > nums[(i+1)%n] ){
                count++;
            }

        }
        if(count>1){
            return false;
        }
        return true;

    }
}
 */