package step4_Binary_Search.step2_BS_on_Answers;

import java.util.Scanner;

public class p5_Find_Smallest_Divisor_With_Given_Threshold {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter threshold");
        int thresh = in.nextInt();
        System.out.println("enter n");
        int n= in .nextInt();
        System.out.println("enter piles array");
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        int min=smallestDivisor(nums,thresh);
        System.out.println(min);
    }
    public static int smallestDivisor(int[] nums, int threshold){
        int low=1;
        int high=max(nums);
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int sum=sum(nums,mid);
            if(sum<=threshold){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int sum(int[] arr, int divisor){
        int n= arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=(int)Math.ceil((double)arr[i]/(double)divisor);
        }
        return sum;
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
