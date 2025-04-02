package step4_Binary_Search.step2_BS_on_Answers;

import java.util.Scanner;

public class p2_Nth_root {
    public static void main(String[] args) {
        System.out.println("enter element");
        Scanner in = new Scanner(System.in);
        int m=in.nextInt();
        System.out.println("enter n (nth root)");
        int n = in.nextInt();
        int sqrt=nthRoot(n,m);
        System.out.println(sqrt);
    }
    public static int nthRoot(int n,int m){
        int low=0;
        int high=m;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int value=1;
            for(int i=0;i<n;i++){
                value*=mid;
            }
            if(value==m) return mid;
            else if(value<m){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}
