package step3_Arrays.lec1_Easy;

import java.util.Scanner;

public class p6_zeroes_at_end {
    public static void main(String[] args) {

        System.out.println("enter size of array");
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        moveZeroes(arr);
    }
//2ms-my solution
    static void moveZeroes(int[] nums){
        int count=0;
        int[] temp=new int[nums.length];
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                temp[k++]=nums[i];
            }
        }
        nums=temp;
        for(int i=k;i<nums.length;i++){
            nums[i]=0;
        }
    }


    //0ms-idela solution
//    public static void moveZeroes(int[] nums) {
//        int j=0;
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]!=0){
//                swap(nums,i,j);
//                j++;
//            }
//        }
//    }
    static void swap(int[] arr , int i , int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
