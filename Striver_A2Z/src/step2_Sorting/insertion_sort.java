package step2_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class insertion_sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter the size of array");
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter elements of array");
        for (int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertionSort(int [] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j>0 && arr[j]<arr[j-1];j--){
                swap(arr,j,j-1);
            }
        }
    }
    static void swap(int[] arr, int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
