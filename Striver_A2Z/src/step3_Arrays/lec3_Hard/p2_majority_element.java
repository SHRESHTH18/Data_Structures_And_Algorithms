package step3_Arrays.lec3_Hard;
import java.util.ArrayList;
import java.util.Scanner;

public class p2_majority_element {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        ArrayList<Integer> list= majorityElement(arr);
        System.out.println(list);
    }

    public static ArrayList<Integer> majorityElement(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            
        }
        return list;
    }

    //takes a lot of time
//    public static ArrayList<Integer> majorityElement(int[] nums){
//        ArrayList<Integer> list = new ArrayList<>();
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            if(map.containsKey(nums[i])){
//                map.replace(nums[i],map.get(nums[i]),map.get(nums[i])+1);
//            }
//            else{
//                map.put(nums[i],1);
//            }
//        }
//        for(int a:map.keySet()){
//            if(map.get(a)>nums.length/3){
//                list.add(a);
//            }
//        }
//        return list;
//    }

}
