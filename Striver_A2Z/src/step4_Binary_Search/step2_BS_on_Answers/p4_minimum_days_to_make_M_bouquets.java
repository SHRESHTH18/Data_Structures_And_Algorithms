package step4_Binary_Search.step2_BS_on_Answers;
import java.util.*;
public class p4_minimum_days_to_make_M_bouquets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n= in.nextInt();
        System.out.println("enter array");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println("enter m");
        int m=in.nextInt();
        System.out.println("enter k");
        int k=in.nextInt();
        int min = minDays(arr,m,k);
        System.out.println(min);
    }
    public static int minDays(int[] bloomDay, int m , int k){
        int n=bloomDay.length;
        int low=min(bloomDay);
        int high=max(bloomDay);
        if(m*k>n) return -1;
        if(m*k==n) return high;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int num_bouquets=possible_bouquets(bloomDay,mid,k);
            if(num_bouquets>=m){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int possible_bouquets(int [] arr, int days , int k){
        int n=arr.length;
        int count=0;
        int num_bouquets=0;
        for(int i=0;i<n;i++){
            if(days<arr[i]){
                count=0;
            }
            else{
                count++;
                if(count==k){
                    num_bouquets++;
                    count=0;
                }
            }
        }
        return num_bouquets;
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
