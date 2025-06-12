package step8_stack_and_queue.lec3_monotonic_stack_queue;
import java.util.*;
public class p6_sum_of_subarray_minimums {
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            int[] nse=findNSE(arr);
            int[] pse= findPSE(arr);
            int n = arr.length;
            long total=0;
            int mod=1000000007;
            for(int i=0;i<n;i++){
                if(nse[i]==-1) nse[i]=n;
                int left = i-pse[i];
                int right = nse[i] - i;
                total = (total + left*right*1L*arr[i]) % mod;
            }
            return (int)total;
        }

        public int[] findPSE(int[] arr){
            Stack<Integer> stack = new Stack<>();
            int n= arr.length;
            int[] pse = new int[n];
            for(int i=0;i<n;i++){
                while(!stack.empty() && arr[i]<arr[stack.peek()]){
                    stack.pop();
                }
                if(!stack.empty()){
                    pse[i]=stack.peek();
                }
                else{
                    pse[i]=-1;
                }
                stack.push(i);
            }

            return pse;
        }

        public int[] findNSE(int[] arr){
            Stack<Integer> stack = new Stack<>();
            int n= arr.length;
            int[] nse = new int[n];
            for(int i=n-1;i>=0;i--){
                while(!stack.empty() && arr[i]<=arr[stack.peek()]){
                    stack.pop();
                }
                if(!stack.empty()){
                    nse[i]=stack.peek();
                }
                else{
                    nse[i]=-1;
                }
                stack.push(i);
            }
            return nse;
        }
    }
}
