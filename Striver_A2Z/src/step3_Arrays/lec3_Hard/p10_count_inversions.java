package step3_Arrays.lec3_Hard;

import java.util.ArrayList;
import java.util.Scanner;

public class p10_count_inversions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n= in.nextInt();
        System.out.println("enter array");
        int [] nums = new int [n];
        for(int i=0;i<n;i++){
            nums[i]= in.nextInt();
        }
        int count = inversionCount(nums);
        System.out.println(count);
    }
    public static int inversionCount(int[] arr){
        int n=arr.length;
        return mergeSort(arr, 0, n - 1);
    }
    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort(arr, low, mid);  // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += merge(arr, low, mid, high);  // merging sorted halves
        return cnt;
    }
    private static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //Modification 1: cnt variable to count the pairs:
        int cnt = 0;

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); //Modification 2
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt; // Modification 3
    }
    //brute force- count krlo n^2
//    public static int inversionCount(int[] arr){
//        int count=0;
//        int n=arr.length;
//        for(int i=0;i<n;i++){
//            for(int j=i;j<n;j++){
//                if(arr[j]<arr[i]){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
}
