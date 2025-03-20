package step3_Arrays.lec2_Medium;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
public class p1_2sum_problem {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("enter target");
        int target= in.nextInt();
        System.out.println("enter n");
        int n=in.nextInt();
        int []nums = new int[n];
        System.out.println("enter array");
        for (int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        int[] arr=twoSum(nums,target);
        System.out.println(Arrays.toString(arr));

    }

    public static int[] twoSum(int[] nums,int target){
        int n =nums.length;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int element = target-nums[i];
            if (map.containsKey(element)){
                return new int[]{map.get(element),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
    //brute force
//    public static int[] twoSum(int[] nums,int target){
//        int [] arr = new int[2];
//        int n =nums.length;
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                if(nums[i]+nums[j]==target){
//                    arr[0]=i;
//                    arr[1]=j;
//                    break;
//                }
//            }
//        }
//        return arr;
//    }
}
