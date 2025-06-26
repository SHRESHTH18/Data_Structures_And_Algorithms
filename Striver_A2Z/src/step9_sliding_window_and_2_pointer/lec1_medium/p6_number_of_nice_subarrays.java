package step9_sliding_window_and_2_pointer.lec1_medium;

public class p6_number_of_nice_subarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k) - helper(nums,k-1);
    }

    public int helper(int[] nums , int goal){
        if(goal<0) return 0;
        int n = nums.length;
        int l=0,r=0 , sum=0 , count=0;
        while(r<n){
            if(nums[r]%2==1){
                sum++;
            }
            while(sum>goal){
                if(nums[l]%2==1){
                    sum--;
                }
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }
}
