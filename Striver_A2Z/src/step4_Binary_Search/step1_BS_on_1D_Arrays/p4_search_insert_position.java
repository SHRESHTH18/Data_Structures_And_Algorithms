package step4_Binary_Search.step1_BS_on_1D_Arrays;

import java.util.Scanner;

public class p4_search_insert_position {
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
        int index = searchInsert(arr,target);
        System.out.println(index);
    }
    public static int searchInsert(int[] nums,int target){
        int n=nums.length;
        int low=0;
        int high=n-1;

        int ans=n;
        while(low<=high){
            int mid=low+ (high-low)/2;
            if(target<=nums[mid]){
                ans=mid;
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
