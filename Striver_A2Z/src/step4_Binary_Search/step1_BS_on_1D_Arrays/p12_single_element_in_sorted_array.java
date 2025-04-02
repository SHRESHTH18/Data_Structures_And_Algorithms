package step4_Binary_Search.step1_BS_on_1D_Arrays;

import java.util.Scanner;

public class p12_single_element_in_sorted_array {
    public static void main(String[] args) {
        System.out.println("enter size of array");
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int single=singleNonDuplicate(arr);
        System.out.println(single);
    }

    public static int singleNonDuplicate(int[] nums){
        int n=nums.length;
        int low=0;
        int high=n-1;
        if(n==1)
            return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid-1]==nums[mid]){
                //single element on left side
                if(mid%2==0){
                    high = mid-1;
                }
                //single element on right side
                else{
                    low=mid+1;
                }
            }
            else if(nums[mid+1]==nums[mid]){
                //single element on right side
                if(mid%2==0){
                    low=mid+1;
                }
                //single element on left side
                else{
                    high=mid-1;
                }
            }
            else{
                return nums[mid];
            }
        }
        return -1;
    }
}
