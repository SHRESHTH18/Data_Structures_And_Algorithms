package step4_Binary_Search.step1_BS_on_1D_Arrays;

import java.util.Scanner;

public class p8_search_in_rotated_sorted_array_unique_elements {
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
        int index = search(arr,target);
        System.out.println(index);
    }
    public static int search(int[] nums,int target){
        int n=nums.length;
        int low=0;int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) return mid;
            //left sorted
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target <=nums[mid]){
                    high = mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            //right sorted
            else{
                if(target<=nums[high] && target>=nums[mid]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }

}
