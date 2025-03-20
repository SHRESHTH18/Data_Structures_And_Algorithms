package step3_Arrays.lec2_Medium;
import java.util.Arrays;
import java.util.Scanner;
/*
approach - sort the array first now check the length of subarray which has the elements 1 greater than the element before it.
 */
public class p10_longest_consecutive_sequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter the size of array");
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter elements of array");
        for (int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }

        int a= longestConsecutive(arr);
        System.out.println(a);
    }
    public static int longestConsecutive(int[] nums){
        int len=0;
        int maxlen=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i==0){
                len=1;
                maxlen=1;
            }
            else if(nums[i]==nums[i-1]+1){
                len++;
                maxlen=Math.max(len,maxlen);
            }
            else if(nums[i]==nums[i-1]){

            }
            else{
                len=1;
            }
        }
        return maxlen;
    }
}
