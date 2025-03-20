package step3_Arrays.lec1_Easy;
import java.util.Scanner;

public class p4_remove_duplicate_from_sorted {
    public static void main(String[] args) {
        System.out.println("enter size of array");
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println(removeDuplicates(arr));

    }

    //3 ms
//    public static int removeDuplicates(int[] nums) {
//        LinkedHashSet<Integer> set= new LinkedHashSet<>();
//        for(int i=0;i<nums.length;i++){
//            set.add((int)nums[i]);
//        }
//        int i=0;
//        for(int a:set){
//            nums[i++]=a;
//        }
//        return set.size();
//
//    }




    //1ms
    static int removeDuplicates(int[] arr){
        int element = arr[0];
        int unique_count=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==element){
                continue;
            }
            else{
                element=arr[i];
                swap(arr,i,unique_count++);

            }
        }
        return unique_count;
    }
    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
