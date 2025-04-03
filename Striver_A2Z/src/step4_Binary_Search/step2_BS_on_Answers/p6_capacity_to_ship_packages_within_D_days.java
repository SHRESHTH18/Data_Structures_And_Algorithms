package step4_Binary_Search.step2_BS_on_Answers;
import java.util.*;
public class p6_capacity_to_ship_packages_within_D_days {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter days");
        int days = in.nextInt();
        System.out.println("enter n");
        int n= in .nextInt();
        System.out.println("enter piles array");
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        int min=shipWithinDays(nums,days);
        System.out.println(min);
    }
    public static int shipWithinDays(int[] weights,int days){
        int low=max(weights);
        int high=sum(weights);
        int ans=-1;
        while(low<=high){
            int mid=low +(high-low)/2;
            int num_days=num_days(weights,mid);
            if(num_days<=days){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int num_days(int[] weights , int cap){
        int n=weights.length;
        int days=1;
        int temp=cap;
        for(int i=0;i<n;i++){
            if(temp-weights[i]>=0){
                temp=temp-weights[i];
            }
            else{
                temp=cap;
                temp=temp-weights[i];
                days++;
            }
        }
        return days;
    }
    public static int sum(int[] arr){
        int n= arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        return sum;
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
