package step4_Binary_Search.step1_BS_on_1D_Arrays;

import java.util.Scanner;

public class p2_find_floor {
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
        int index = findFloor(arr,target);
        System.out.println(index);
    }
    public static int findFloor(int[] arr,int x){
        int n = arr.length;

        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                ans = mid;     // Potential floor found
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return ans;
    }
}
