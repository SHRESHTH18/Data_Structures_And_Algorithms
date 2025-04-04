package step4_Binary_Search.step2_BS_on_Answers;

import java.util.Scanner;

public class p12_Minimise_max_distance_to_gas_station {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter k");
        int k = in.nextInt();
        System.out.println("enter n");
        int n= in .nextInt();
        System.out.println("enter array");
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        double min=MinMaxDistance(nums,k);
        System.out.println(min);
    }
    public static double MinMaxDistance(int[] nums,int k){
        int n=nums.length;
        double low=0;
        double high=0;
        for(int i=0;i<n-1;i++){
            double diff=(nums[i+1]-nums[i]);
            high=Math.max(high,diff);
        }
        while(high-low>1e-6){
            double mid = (low+high)/2.0;
            int count=countGasStation(nums,mid);
            if(count>k)
                low=mid;
            else
                high=mid;

        }
        return high;
    }
    public static int countGasStation(int[] nums,double dist){
        int count=0;
        for(int i=1;i<nums.length;i++){
            int between=(int)((nums[i] - nums[i-1])/dist);

            //in case of [1,2] and dist = 0.5 , number of gas stations in between would be 1  but our formula would give (2-1)/0.5 = 2
            //hence we have to subtract 1 ( the endpoint) in such cases
            if((double)(nums[i] - nums[i-1])/dist == (double)between) {
                between--;
            }
            count+=between;
        }
        return count;
    }
//    public static double MinMaxDistance(int[] nums,int k){
//        int n=nums.length;
//        int[] howMany = new int[n-1];
//        for(int station=1;station<=k;station++){
//            double maxSection=-1;
//            int maxInd=-1;
//            for(int i=0;i<n-1;i++){
//                double diff=nums[i+1]-nums[i];
//                double sectionLength=diff/((double)howMany[i]+1);
//                if(sectionLength>maxSection){
//                    maxSection=sectionLength;
//                    maxInd=i;
//                }
//            }
//            howMany[maxInd]++;
//        }
//        double maxAns=-1;
//        for(int i=0;i<n-1;i++){
//            double diff=nums[i+1]-nums[i];
//            double sectionLength=diff/(double)(howMany[i]+1);
//            maxAns=Math.max(maxAns,sectionLength);
//        }
//        return maxAns;
//    }
}
