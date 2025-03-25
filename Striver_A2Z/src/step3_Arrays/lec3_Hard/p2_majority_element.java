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



    /*

    approach - max 2 elements can have count>n/3
    dono ka count rkhlo
    if count 0 h to set element and count =1
    fir same element to count++
    agar dono elements se match nahi kr rha to dono ka count--;

     */

    public static ArrayList<Integer> majorityElement(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        int c1=0,c2=0;
        int el1=0,el2=0;
        for(int i=0;i<nums.length;i++){
            if(c1==0 && el2!=nums[i]){
                el1=nums[i];
                c1=1;
            }
            else if(c2==0 && el1!= nums[i]) {
                el2=nums[i];
                c2=1;
            }
            else if(nums[i]==el1){
                c1++;
            }


            else if(nums[i]==el2){
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }


        //just manually verifying the answer

        int count1=0;
        int count2=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]==el1){
                count1++;
            }
            else if(nums[i]==el2){
                count2++;
            }
        }
        if(count1>nums.length/3){
            list.add(el1);
        }
        if(count2>nums.length/3){
            list.add(el2);
        }
        return list;
    }

    //takes a lot of time -16 ms
    /*
    approach - map me element store krlo with their count ,
    if element present, count++ else new key value pair add kro (element,1)
     */
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
    //brute -1436 ms
//    public static ArrayList<Integer> majorityElement(int[] nums){
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i=0;i<nums.length;i++){
//            int count=0;
//            for(int j=0;j<nums.length;j++){
//                if(nums[i]==nums[j]){
//                    count+=1;
//                }
//            }
//            if(count>nums.length/3 && !list.contains(nums[i])){
//                list.add(nums[i]);
//            }
//        }
//        return list;
//    }

}
