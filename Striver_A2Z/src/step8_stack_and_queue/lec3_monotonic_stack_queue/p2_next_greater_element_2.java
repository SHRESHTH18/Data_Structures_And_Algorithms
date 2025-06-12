package step8_stack_and_queue.lec3_monotonic_stack_queue;

public class p2_next_greater_element_2 {

    //brute - O(n^2)
//    public int[] nextGreaterElements(int[] nums) {
//        int n= nums.length;
//        int[] ans = new int[n];
//        for(int i=0;i<n;i++){
//            ans[i]=-1;
//        }
//        for(int i=0;i<n;i++){
//            for(int j=1;j<n;j++){
//                if(nums[(i+j)%n]>nums[i]){
//                    ans[i]=nums[(i+j)%n];
//                    break;
//                }
//            }
//        }
//        return ans;
//    }
}
