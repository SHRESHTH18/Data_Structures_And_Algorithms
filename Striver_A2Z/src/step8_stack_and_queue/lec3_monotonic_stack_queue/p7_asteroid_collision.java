package step8_stack_and_queue.lec3_monotonic_stack_queue;
import java.util.Stack;
public class p7_asteroid_collision {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            int n=asteroids.length;
            Stack<Integer> stack = new Stack<>();
            for(int i=0;i<n;i++){
                if(asteroids[i]>0){
                    stack.push(asteroids[i]);
                }
                else{
                    while(!stack.empty() && stack.peek()>0 && stack.peek()<Math.abs(asteroids[i])){
                        stack.pop();
                    }
                    if(!stack.empty() && stack.peek()==Math.abs(asteroids[i])){
                        stack.pop();
                    }
                    else if(stack.empty() || stack.peek()<0){
                        stack.push(asteroids[i]);
                    }
                }
            }
            int size= stack.size();
            int[] arr = new int[size];
            for(int i=size-1 ; i>=0;i--){
                arr[i] = stack.pop();
            }
            return arr;
        }
    }
}
