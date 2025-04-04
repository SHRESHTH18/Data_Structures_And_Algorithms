package step4_Binary_Search.step2_BS_on_Answers;

import java.util.Scanner;

public class p8_Aggressive_cows {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter number of cows");
        int k = in.nextInt();
        System.out.println("enter n");
        int n= in .nextInt();
        System.out.println("enter array");
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        int min=aggressive_cows(nums,k);
        System.out.println(min);
    }
    public static int aggressive_cows(int[] nums,int k){
        int low=1;
        int high = max(nums) - min(nums);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canWePlaceCow(nums,mid,k)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high;
    }
    public static boolean canWePlaceCow(int[] nums,int dist , int k){
        int n= nums.length;
        int count=1;
        int last = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]-last>=dist){
                count++;
                last=nums[i];
            }
        }
        if(count>=k) return true;
        return false;
    }
    public static int min(int [] arr){
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,arr[i]);
        }
        return min;
    }
    public static int max(int [] arr){
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}
