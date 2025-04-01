package step4_Binary_Search.step1_BS_on_1D_Arrays;

import java.util.Scanner;
import java.util.*;
public class p5_get_floor_and_ceil {
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
        int[] floor_and_ceil = getFloorAndCeil(arr,arr.length,target);
        System.out.println(Arrays.toString(floor_and_ceil));
    }
    public static int[] getFloorAndCeil(int[] a,int n,int x){
        int low=0;int high=n-1;
        int floor=n;
        int ceil=n;
        int[] ind=new int[2];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(a[mid]==x){
                floor=a[mid];
                ceil=a[mid];
                ind[0]=floor;
                ind[1]=ceil;
                return ind;
            }
            else if(x>a[mid]){
                floor=a[mid];
                if(mid==n-1){
                    ceil=-1;
                }
                else{
                    ceil=a[mid+1];
                }
                low=mid+1;
            }
            else{
                if(mid==0){
                    floor=-1;
                }
                else{
                    floor=a[mid-1];
                }
                ceil=a[mid];
                high = mid-1;
            }
        }

        ind[0]=floor;
        ind[1]=ceil;
        return ind;
    }
}
