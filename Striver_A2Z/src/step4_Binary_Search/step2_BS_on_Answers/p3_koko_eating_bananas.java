package step4_Binary_Search.step2_BS_on_Answers;
import java.util.*;
public class p3_koko_eating_bananas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter hours");
        int h = in.nextInt();
        System.out.println("enter n");
        int n= in .nextInt();
        System.out.println("enter piles array");
        int[] piles = new int[n];
        for(int i=0;i<n;i++){
            piles[i]=in.nextInt();
        }
        int min=minEatingSpeed(piles,h);
        System.out.println(min);
    }
    public static int minEatingSpeed(int[] piles,int h){
        int low=1;
        int high=maxEatingSpeed(piles);
        int ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            long time = eatingPile(piles,mid);
            if(time<=(long)h) {
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;

    }
    public static long eatingPile(int[] a,int speed){
        long time=0;
        int n=a.length;
        for(int i=0;i<n;i++){
            time = time + (long)Math.ceil((double)a[i]/(double)speed);
        }
        return time;
    }
    public static int maxEatingSpeed(int[] piles){
        int n=piles.length;
        int max=Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            max=Math.max(max,piles[i]);
        }
        return max;
    }
}
