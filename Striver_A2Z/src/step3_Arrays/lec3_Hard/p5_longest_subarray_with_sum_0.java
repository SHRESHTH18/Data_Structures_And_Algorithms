package step3_Arrays.lec3_Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

public class p5_longest_subarray_with_sum_0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int len= maxLen(arr);
        System.out.println(len);
    }

    /*
    brute- check sum of all subarrays possible
    better - store sum in a hashmap .
     */
    public static int maxLen(int[] arr){
        int n=arr.length;
        int maxLen=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0){
                maxLen=Math.max(i+1,maxLen);
            }
            if(map.containsKey(sum)){
                int len=i-map.get(sum);
                maxLen=Math.max(maxLen,len);
            }
            map.putIfAbsent(sum,i);
        }
        return maxLen;
    }
}
