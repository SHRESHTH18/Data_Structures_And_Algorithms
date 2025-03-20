package step3_Arrays.lec2_Medium;
import java.util.Arrays;
import java.util.Scanner;
public class p7_rearrange_array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int[] a= rearrangeArray(arr);
        System.out.println(Arrays.toString(a));
    }


    public static int[] rearrangeArray(int[]nums){
        int posindex=0;
        int negindex=1;
        int[] answer = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                answer[negindex]=nums[i];
                negindex+=2;
            }
            else{
                answer[posindex]=nums[i];
                posindex+=2;
            }
        }
        return answer;
    }

    //making 2 new arrays
//    public static int[] rearrangeArray(int[]nums){
//        int [] posarr= new int[nums.length/2];
//        int [] negarr= new int[nums.length/2];
//        int p=0,n=0;
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]<0){
//                negarr[n++]=nums[i];
//            }
//            else{
//                posarr[p++]=nums[i];
//            }
//        }
//        p=0;
//        n=0;
//        for(int i=0;i<nums.length;i=i+2){
//            nums[i]=posarr[p++];
//            nums[i+1]=negarr[n++];
//        }
//        return nums;
//    }
}
