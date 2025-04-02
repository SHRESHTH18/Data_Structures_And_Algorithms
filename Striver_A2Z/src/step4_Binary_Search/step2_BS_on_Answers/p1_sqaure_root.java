package step4_Binary_Search.step2_BS_on_Answers;

import java.util.Scanner;

public class p1_sqaure_root {
    public static void main(String[] args) {
        System.out.println("enter element");
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int sqrt=floorSqrt(n);
        System.out.println(sqrt);
    }
    public static int floorSqrt(int n){
        int low=0;
        int high=n;
        int ans=-1;
        while(low<=high){
            int mid=low+ (high-low)/2;
            if(mid*mid<=n){
                ans = mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}
