package step4_Binary_Search.step2_BS_on_Answers;

import java.util.Scanner;

public class p9_Book_Allocation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter number of students");
        int students = in.nextInt();
        System.out.println("enter n");
        int n= in .nextInt();
        System.out.println("enter array");
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        int min=findPages(nums,students);
        System.out.println(min);
    }
    public static int findPages(int[] arr,int std){
        if(std>arr.length) return -1;
        int low=max(arr);
        int high=sum(arr);
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int value=num_Students(arr,mid);
            if(value<=std){
                high=mid-1;
                ans=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;//low=high+1=mid-1+1=mid(which is our answer)  after last iteration

    }
    public static int num_Students(int[] arr,int cap){
        //cap-capacity of each student at max
        int n = arr.length;
        int temp=cap;
        temp=temp-arr[0];
        int count=1;
        for(int i=1;i<n;i++){
            if(temp>=arr[i]){
                temp=temp-arr[i];
            }
            else{
                count++;
                temp=cap-arr[i];
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

