package step3_Arrays.lec1_Easy;
import java.util.Scanner;
import java.util.HashMap;
public class p13_len_longest_subarray{
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("enter size of array");
        int n= in.nextInt();
        System.out.println("enter k:");
        int k = in.nextInt();

        int [] arr =new int[n];
        System.out.println("enter array");
        for (int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int len = lenOfLongestSubarr(arr,k);
        System.out.println(len);
    }

    //using hashmap
    public static int lenOfLongestSubarr(int[]arr , int k){
        int maxLen = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum equals k, update maxLen
            if (sum == k) {
                maxLen = i + 1;
            }

            // If (sum - k) exists in the map, update maxLen
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }

            // Store sum index if not present
            map.putIfAbsent(sum, i);
        }

        return maxLen;
    }


    //TLE - making a table for sum of elements

//    public static int lenOfLongestSubarr(int[] arr,int k){
//        int n = arr.length;
//        int [][] cumSum = new int[n][n];
//        for (int i=0;i<n;i++){
//            cumSum[i][i]=arr[i];
//            for (int j=i+1;j<n;j++){
//                cumSum[i][j] = cumSum[i][j-1] + arr[j];
//            }
//        }
//        int maxLen=0;
//        for(int i=0;i<n;i++){
//            for (int j=i ;j<n;j++){
//                if(cumSum[i][j]==k){
//                    if(j+1-i>maxLen){
//                        maxLen=j+1-i;
//                    }
//                }
//            }
//        }
//        return maxLen;
//    }
}