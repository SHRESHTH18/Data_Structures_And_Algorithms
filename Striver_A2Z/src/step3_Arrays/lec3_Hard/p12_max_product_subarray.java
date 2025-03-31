package step3_Arrays.lec3_Hard;

import java.util.Scanner;

public class p12_max_product_subarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n= in.nextInt();
        System.out.println("enter array");
        int [] nums = new int [n];
        for(int i=0;i<n;i++){
            nums[i]= in.nextInt();
        }
        int count = maxProduct(nums);
        System.out.println(count);
    }
    public static int maxProduct(int[] nums){
        int n= nums.length;
        int pre=1,suff=1;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(pre==0) pre=1;
            if(suff==0) suff=1;
            pre=pre*nums[i];
            suff=suff*nums[n-i-1];
            ans=Math.max(ans,Math.max(pre,suff));
        }
        return ans;
    }
}
