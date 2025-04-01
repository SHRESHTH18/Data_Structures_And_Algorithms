package step4_Binary_Search.step1_BS_on_1D_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class p7_count_frequency {
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
        int count = countFreq(arr,target);
        System.out.println(count);
    }
    public static int countFreq(int[] arr,int target){
        int count=0;
        int n=arr.length;
        int low=0;int high=n-1;
        while(low<=high){
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                // Count the mid element
                count = 1;

                // Count elements to the left of mid
                int left = mid - 1;
                while (left >= low && arr[left] == target) {
                    count++;
                    left--;
                }

                // Count elements to the right of mid
                int right = mid + 1;
                while (right <= high && arr[right] == target) {
                    count++;
                    right++;
                }
                return count;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return count;
    }

    //recursive
    /*
    public static int countFreq(int[] arr, int target, int low, int high) {
    if (low > high) return 0;
    int mid = low + (high - low) / 2;
    if (arr[mid] == target) {
        // Count the current element (1) and count recursively in both directions
        return 1
            + countFreq(arr, target, low, mid - 1)
            + countFreq(arr, target, mid + 1, high);
    }
    else if (arr[mid] > target) {
        return countFreq(arr, target, low, mid - 1);
    }
    else {
        return countFreq(arr, target, mid + 1, high);
    }
}
     */
}
