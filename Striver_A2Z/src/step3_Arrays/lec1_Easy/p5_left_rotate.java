package step3_Arrays.lec1_Easy;

import java.util.Arrays;
import java.util.Scanner;

public class p5_left_rotate {
    public static void main(String[] args) {
        System.out.println("enter size of array");
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println("enter k");
        int k=in.nextInt();

        rotate(arr,k);
    }

    //2ms
//    static void rotate(int[] nums, int k) {
//        int[] temp=new int[nums.length];
//        for(int i=k;i<k+nums.length;i++){
//            temp[i%nums.length]= nums[i-k];
//        }
//        for(int i=0;i<nums.length;i++){
//            nums[i]=temp[i];
//        }
//    }


    //O(n^2) TLE
//    static void rotate(int[] nums,int k){
//        int len=nums.length;
//        for(int i=0;i<k;i++){
//            int current=nums[0];
//            for(int j=1;j<len;j++){
//                int temp=nums[j];
//                nums[j]=current;
//                current=temp;
//            }
//            nums[0]=current;
//        }
//    }

    static void rotate(int[] nums , int k){
        int len=nums.length;
        int[] temp= new int[k];
        int ind=0;
        for (int i=len-k;i<len;i++){
            temp[ind] = nums[i];
            ind++;
        }
        System.out.println(Arrays.toString(temp));
        for(int j=len-1;j>=k;j--){
            nums[j]=nums[j-len+k-1];
        }
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<k;i++){
            nums[i]=temp[i];
        }
        System.out.println(Arrays.toString(nums));

    }
}
