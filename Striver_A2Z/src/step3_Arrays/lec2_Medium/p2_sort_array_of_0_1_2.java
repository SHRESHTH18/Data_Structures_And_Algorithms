package step3_Arrays.lec2_Medium;
import java.util.Scanner;

public class p2_sort_array_of_0_1_2 {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        sortColors(arr);
    }

    public static void sortColors(int[] nums){
        int[] count = new int[3];
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        int index=0;
        for(int i=0;i<3;i++){
            while(count[i]>0){
                nums[index++]=i;
                count[i]--;
            }
        }
    }

    //using hashmap
//    public static void sortColors(int[] nums){
//        HashMap<Integer,Integer> map = new HashMap<>();
//        map.put(0,0);
//        map.put(1,0);
//        map.put(2,0);
//        for(int i=0;i<nums.length;i++){
//            map.put(nums[i],map.get(nums[i])+1);
//        }
//        int j=0;
//        for(int a=0;a<map.get(0);a++){
//            nums[j]=0;
//            j++;
//        }
//        for(int a=0;a<map.get(1);a++){
//            nums[j]=1;
//            j++;
//        }
//        for(int a=0;a<map.get(2);a++){
//            nums[j]=2;
//            j++;
//        }
//        System.out.println(Arrays.toString(nums));
//    }


    //quicksort
//    public static void sortColors(int[] nums){
//        quickSort(nums,0,nums.length-1);
//        System.out.println(Arrays.toString(nums));
//    }
//    public static void quickSort(int[]nums , int l,int h){
//        if(l<h){
//            int j = partition(nums, l, h);
//            quickSort(nums, l, j - 1);
//            quickSort(nums, j + 1, h);
//        }
//    }
//    public static int partition(int[] nums,int l,int h){
//        int pivot = nums[l];
//        int i=l+1;
//        int j=h;
//        while(i<=j){
//            while(i<=j && nums[i]<=pivot){
//                i++;
//            }
//            while(j>=i && nums[j]>pivot){
//                j--;
//            }
//            if(i<j){
//                swap(nums,i,j);
//            }
//        }
//        swap(nums, l, j);
//
//        return j;
//    }
//    public static void swap(int[]arr , int a , int b){
//        int temp=arr[a];
//        arr[a]=arr[b];
//        arr[b]=temp;
//    }


    //bubble sort
//    public static void sortColors(int[] nums) {
//        for(int i=0;i<nums.length;i++){
//            for (int j=0;j<nums.length-1;j++){
//                if(nums[j]>nums[j+1]){
//                    int temp=nums[j];
//                    nums[j]=nums[j+1];
//                    nums[j+1]=temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//    }
}
