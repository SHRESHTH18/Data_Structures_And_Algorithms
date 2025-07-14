package step16_dp.lec3_dp_on_subsequences;

public class p3_partition_array_into_2_subsets_with_min_abs_difference {
    public int minimumDifference(int[] nums) {

        int n=nums.length;
        int totalSum=0;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }
        return helper(n-1,0,0,totalSum,nums);
    }
    public int helper(int i,int sum,int count,int totalSum,int[] nums){
        if(i==-1){
            int n=nums.length;
            if(count==0||count==n) return (int)1e9;
            return Math.abs(sum-(totalSum-sum));
        }

        int take=helper(i-1,sum+nums[i],count+1,totalSum,nums);
        int nottake=helper(i-1,sum,count,totalSum,nums);
        return Math.min(take,nottake);
    }
}
