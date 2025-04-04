package step4_Binary_Search.step2_BS_on_Answers;

import java.util.Scanner;

public class p7_kth_missing_positive_number {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter k");
        int k = in.nextInt();
        System.out.println("enter n");
        int n= in .nextInt();
        System.out.println("enter array");
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        int min=findKthPositive(nums,k);
        System.out.println(min);
    }
    public static int findKthPositive(int[] arr , int k){
        int n=arr.length;
        int low=0;
        int high=n-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            int missing = arr[mid] - (mid+1);
            if(missing<k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return low+k;
    }
}
