package step4_Binary_Search.step1_BS_on_1D_Arrays;

import java.util.Scanner;

public class p9_search_in_rotated_sorted_array_repeated {
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
        boolean index = search(arr,target);
        System.out.println(index);
    }
    public static boolean search(int[] nums,int target){
        int n=nums.length;
        int low=0;int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) return true;
            if(nums[low]==nums[mid] && nums[high]==nums[mid]){
                low++;
                high--;
                continue;//to check if abhi bhi low and high elements equal h kya
            }
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
        return false;
    }

    //if it is rotating right only - this solution is correct
    // NO THIS IS WRONG .
//    public static boolean search(int[] nums,int target){
//        int n=nums.length;
//        int low=0;int high=n-1;
//        while(low<=high){
//            int mid=low+(high-low)/2;
//            if(nums[mid]==target) return true;
//            //right sorted
//            if(nums[high]>=nums[mid]){
//                if(target<=nums[high] && target>=nums[mid]){
//                    low=mid+1;
//                }
//                else{
//                    high=mid-1;
//                }
//            }
//            //left sorted
//            else{
//                if(target>=nums[low] && target <=nums[mid]){
//                    high = mid-1;
//                }
//                else{
//                    low=mid+1;
//                }
//            }
//        }
//        return false;
//    }
}
