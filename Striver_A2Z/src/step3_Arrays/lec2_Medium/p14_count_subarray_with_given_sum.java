package step3_Arrays.lec2_Medium;
import java.util.Scanner;
import java.util.HashMap;

public class p14_count_subarray_with_given_sum {
    public static void main(String[] args) {
        System.out.println("enter k");
        Scanner in = new Scanner(System.in);
        int k= in.nextInt();
        System.out.println("enter the size of array");
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter elements of array");
        for (int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }

        int a= subarraySum(arr,k);
        System.out.println(a);
    }



    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int n=nums.length;
        int count=0;
        int sum=0;
        map.put(0,1);
        for(int num:nums){
            sum+=num;
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    //better
//    public static int subarraySum(int[] nums,int k){
//        int n=nums.length;
//        int count=0;
//        for(int i=0;i<n;i++){
//            int sum=0;
//            for(int j=i;j<n;j++){
//                sum+=nums[j];
//                if(sum==k){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
    //brute force
//    public static int subarraySum(int[] nums,int k){
//        int n=nums.length;
//        int count=0;
//        for(int i=0;i<n;i++){
//            for(int j=i;j<n;j++){
//                int sum=0;
//                for(int a=i;a<=j;a++){
//                    sum+=nums[a];
//                }
//                if(sum==k){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
}
