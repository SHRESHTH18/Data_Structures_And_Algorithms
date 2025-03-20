package step2_Sorting;
import java.util.Arrays;
import java.util.Scanner;

public class selection_sort {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("enter the size of array");
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter elements of array");
        for (int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }

        SelectionSort(arr);


    }
    static void SelectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int min=min_index(arr,i);
            if(min!=i){
                swap(arr,min,i);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    static int min_index(int[] arr,int start){
        int min=start;
        for(int i=start;i<arr.length;i++){
            if(arr[i]<arr[min]){
                min=i;
            }
        }
        return min;
    }
    static void swap(int[] arr,int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
