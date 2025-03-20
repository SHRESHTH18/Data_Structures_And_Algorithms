package step3_Arrays.lec2_Medium;
import java.util.Scanner;
public class p6_stock_buy_sell {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int a= maxProfit(arr);
        System.out.println(a);
    }
    //O(n)
    public static int maxProfit(int [] prices){
        int max=0;
        int small=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>=small){
                int profit = prices[i] - small;
                max = Math.max(profit, max);
            }
            else{
                small=prices[i];
            }
        }
        return max;
    }
    //O(n^2)
//    public static int maxProfit(int[] prices){
//        int max=0;
//        for(int i=0;i<prices.length;i++){
//            for (int j=i;j<prices.length;j++){
//                max = Math.max(max,prices[j]-prices[i]);
//            }
//        }
//        return max;
//    }
}
