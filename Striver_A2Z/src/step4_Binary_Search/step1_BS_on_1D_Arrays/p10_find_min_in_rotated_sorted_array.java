package step4_Binary_Search.step1_BS_on_1D_Arrays;
import java.util.*;
public class p10_find_min_in_rotated_sorted_array {
    public static void main(String[] args) {
        System.out.println("enter size of array");
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int min=findMin(arr);
    }
    public static int findMin(int [] nums){
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        int low=0;
        int high = n-1;
        while(low<=high){
            int mid=low+ (high-low)/2;
            min=Math.min(nums[mid],min);
            //agar right side me chhota element exist krta hai to wahi pr minimum hoga
            if(nums[high]<nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return min;
    }
}
