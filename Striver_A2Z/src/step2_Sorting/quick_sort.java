package step2_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class quick_sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter the size of array");
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter elements of array");
        for (int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }

        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int[] arr, int low,int high){
        if(low<high){
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }
    static int partition(int[]arr, int low,int high){
        int pivot=arr[low];
        int mid=low+(high-low)/2;
        int i =low, j=high;
        while(i<j){
            while(i<high && arr[i]<=pivot){
                i++;
            }
            while(j>low && arr[j]>pivot){
                j--;
            }
            if(i<j){
                swap(arr,i,j);
            }

        }
        swap(arr,j,low);
        return j;
    }
    static void swap(int[] arr , int i , int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
