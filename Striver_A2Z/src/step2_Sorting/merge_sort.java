package step2_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class merge_sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter the size of array");
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter elements of array");
        for (int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }

        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int[] arr , int l,int r){
        if(l>=r){
            return;
        }
        int mid=l + (r-l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    static void merge(int arr[],int l , int mid,int r){
        int[] temp = new int[r-l+1];
        int i=l,j=mid+1,k=0;

        while(i<=mid && j <=r){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        while(i<= mid){
            temp[k++]=arr[i++];
        }
        while(j<=r){
            temp[k++]=arr[j++];
        }
        for (int p = 0; p < temp.length; p++) {
            arr[l + p] = temp[p];
        }
    }
}
