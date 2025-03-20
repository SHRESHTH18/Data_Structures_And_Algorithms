package step3_Arrays.lec1_Easy;

import java.util.Scanner;

public class p2_second_largest {
    public static void main(String[] args) {
        System.out.println("enter size of array");
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println(getSecondLargest(arr));
    }
    static int getSecondLargest(int[] arr) {
        // Code Here
        int max=arr[0];
        int second=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                second=max;
                max=arr[i];

            }
            if(arr[i]>second && arr[i]<max){
                second=arr[i];
            }
        }
        if(second==0){
            return -1;
        }
        return second;
    }
}
