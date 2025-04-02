package step4_Binary_Search.step1_BS_on_1D_Arrays;

import java.util.Scanner;

public class p13_find_peak_element {
    public static void main(String[] args) {
        System.out.println("enter size of array");
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int index=findPeakElement(arr);
        System.out.println(index);
    }
    public static int findPeakElement(int[] nums){
        int n = nums.length; // Size of array

// Edge cases:
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If nums[mid] is the peak:
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
                return mid;

            // If we are in the left:
            if (nums[mid] > nums[mid - 1])
                low = mid + 1;
            else
                // If we are in the right or nums[mid] is a common point:
                high = mid - 1;
        }
// Dummy return statement
        return -1;
    }

    //linear - O(n)
//    public static int findPeakElement(int[] nums){
//        int n=nums.length;
//        for(int i=0;i<n;i++){
//            /*
//            if condition covers all cases -
//             i==0 and a[0]>a[1]
//             i==n-1 and a[n-1] >a[n-2]
//             0<i<n-1 -> a[i-1]<a[i]<a[i+1]
//             */
//            if((i==0 || nums[i-1]<nums[i]) && (i==n-1 || nums[i]>nums[i+1])){
//                return i;
//            }
//        }
//        return -1;
//    }
}
