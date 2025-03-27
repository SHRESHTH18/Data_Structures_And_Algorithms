package step3_Arrays.lec3_Hard;
import java.util.*;
public class p6_subarray_with_given_XOR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println("enter target");
        int target = in.nextInt();
        int count = solve(arr,target);
        System.out.println(count);
    }
    public static int solve(int[]A , int B){
        int count = 0;
        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        map.put(0, 1); // To handle cases where subarray itself equals B

        for (int i = 0; i < n; i++) {
            xor = xor ^ A[i];

            int x = xor ^ B;

            // Fix: Avoid NullPointerException by using getOrDefault
            count += map.getOrDefault(x, 0);

            // Fix: Use put() instead of replace() to update frequency safely
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
}
