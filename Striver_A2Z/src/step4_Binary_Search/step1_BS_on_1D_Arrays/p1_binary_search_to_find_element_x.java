package step4_Binary_Search.step1_BS_on_1D_Arrays;

import java.util.Scanner;

public class p1_binary_search_to_find_element_x {
    public static void main(String[] args) {
        System.out.println("enter size of array");
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println("enter target");
        int target=in.nextInt();
        int index = search(arr,0,n-1,target);
        System.out.println(index);
    }

    //RECURSIVE
    public static int search(int[] nums,int low,int high,int target){
        if(low>high){
            return -1;
        }
        int mid = low + (high-low)/2;
        if(nums[mid]==target) return mid;
        else if(target>nums[mid])
            return search(nums,mid+1,high,target);
        else
            return search(nums,low,mid-1,target);
    }

    //ITERATIVE
//    public static int search(int[] nums,int target){
//        int n=nums.length;
//        int low=0;
//        int high=n-1;
//        while(low<=high){
//            int mid= low + (high-low)/2;
//            if(nums[mid]==target) return mid;
//            else if(target>nums[mid]) low=mid+1;
//            else high=mid-1;
//        }
//        return -1;
//    }
}
