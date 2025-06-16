package step8_stack_and_queue.lec4_implementation_problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class p1_sliding_window_maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n= nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> dq= new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.getFirst()<=i-k){
                dq.removeFirst();
            }
            while(!dq.isEmpty()&& nums[dq.getLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1) result[i-k+1]=nums[dq.getFirst()];
        }
        return result;
    }
}
