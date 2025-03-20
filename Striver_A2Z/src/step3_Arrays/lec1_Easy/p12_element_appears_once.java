package step3_Arrays.lec1_Easy;

import java.util.ArrayList;
import java.util.Scanner;

public class p12_element_appears_once {
    public static void main(String[] args) {
        System.out.println("enter size of array");
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int [] arr= new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println(singleNumber(arr));
    }


    //150 ms
    static int singleNumber(int[] nums){
        ArrayList<Integer> list= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        int size= list.size();
        int i=0;
        while(size>0){
            int flag=0;
            int a=list.get(0);
            for(int j=1;j<size;j++){
                if(a==list.get(j)){
                    list.remove(j);
                    list.remove(0);

                    System.out.println(list);
                    flag=1;
                    break;
                }
            }
            if (flag==0){
                return list.get(0);
            }
            size=list.size();

        }
        return -1;
    }


    //1ms
//    public static int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        if(nums.length==1){
//            return nums[0];
//        }
//        for(int i=0;i<nums.length-1;i+=2){
//            if(nums[i]!=nums[i+1]){
//                return nums[i];
//            }
//        }
//        return nums[nums.length-1];
//    }


}
