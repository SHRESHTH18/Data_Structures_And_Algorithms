package step4_Binary_Search.step1_BS_on_1D_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class p6_first_and_last_element_in_sorted_array {
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
        int[] range = searchRange(arr,target);
        System.out.println(Arrays.toString(range));
    }

    //binary search
    public static int[] searchRange(int[] nums,int target){
        int n=nums.length;
        int[] ans = new int [2];
        ans[0]=-1;ans[1]=-1;
        //lower element
        int low=0;int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==nums[mid]){
                ans[0]=mid;
                high=mid-1;
            }
            else if(target>nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }

        }
        //upper element
        low=0;high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==nums[mid]){
                ans[1]=mid;
                low=mid+1;
            }
            else if(target>nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }

        }
        return ans;
    }

    //linear search
//    public static int[] searchRange(int[] nums,int target){
//        int n=nums.length;
//        int[] ans = new int[2];
//        ans[0]=-1;ans[1]=-1;
//        for(int i=0;i<n;i++){
//            if(nums[i]==target){
//                ans[0]=i;
//                break;
//            }
//        }
//        for(int i=n-1;i>=0;i--){
//            if(nums[i]==target){
//                ans[1]=i;
//                break;
//            }
//        }
//        return ans;
//    }
}
