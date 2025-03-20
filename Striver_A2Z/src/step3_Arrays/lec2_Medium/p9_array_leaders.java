package step3_Arrays.lec2_Medium;
import java.util.ArrayList;
import java.util.Scanner;
/*
approach
using a O(n^2) to check for every element if an element bigger than this element lies on the right of it.
 */
public class p9_array_leaders {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter the size of array");
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter elements of array");
        for (int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }

        ArrayList<Integer> list= leaders(arr);
        System.out.println(list);
    }
    public static ArrayList<Integer> leaders(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int flag=0;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]) {
                    flag = 1;
                    break;
                }
            }
            if(flag==0){
                list.add(arr[i]);
            }
        }
        return list;
    }
}
