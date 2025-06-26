package step9_sliding_window_and_2_pointer.lec1_medium;

public class p5_binary_subarray_with_sum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums,goal) - helper(nums,goal-1);
    }
    public int helper(int[] nums , int goal){
        if(goal<0) return 0;
        int n = nums.length;
        int l=0,r=0 , sum=0 , count=0;
        while(r<n){
            sum+=nums[r];
            while(sum>goal){
                sum=sum-nums[l];
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }
}
