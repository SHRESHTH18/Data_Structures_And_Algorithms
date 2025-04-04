package step4_Binary_Search.step2_BS_on_Answers;

import java.util.Scanner;

public class p10_split_array_largest_sum {
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
        int min=splitArray(nums,k);
        System.out.println(min);
    }
    public static int splitArray(int[] nums,int k){
        int low=max(nums);
        int high=sum(nums);
        while(low<=high){
            int mid=low+(high-low)/2;
            System.out.println("mid:"+mid);
            int value=num_splits(nums,mid);
            System.out.println("value:"+value);
            if(value<=k){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public static int num_splits(int[] nums, int cap){
        int n= nums.length;
        int temp=cap;
        temp=temp-nums[0];
        int count=1;
        for(int i=1;i<n;i++){
            if(temp>=nums[i]){
                temp=temp-nums[i];
            }
            else{
                count++;
                temp=cap-nums[i];
            }
        }
        return count;
    }
    public static int max(int [] arr){
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
    public static int sum(int[] arr){
        int n= arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        return sum;
    }
}
