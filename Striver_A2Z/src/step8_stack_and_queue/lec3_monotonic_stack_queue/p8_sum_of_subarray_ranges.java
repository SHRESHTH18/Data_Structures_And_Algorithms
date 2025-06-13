package step8_stack_and_queue.lec3_monotonic_stack_queue;

public class p8_sum_of_subarray_ranges {
    public long subArrayRanges(int[] nums) {
        int n= nums.length;
        long sum=0;
        for(int i=0;i<n;i++){
            int min=nums[i];
            int max=nums[i];
            for(int j=i+1;j<n;j++){
                min=Math.min(min,nums[j]);
                max=Math.max(max,nums[j]);
                sum+=max-min;
            }
        }
        return sum;
    }
}
