package step3_Arrays.lec3_Hard;

import java.lang.reflect.Array;
import java.util.*;

public class p3_3sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        ArrayList<ArrayList<Integer>> list= threeSum(arr);
        System.out.println(list);
    }


    /*
    TLE
    approach -
    same as below but
     map me ham 2 elements nahi ek hi element store kr rhe hai and uska index
     */

//    public static ArrayList<ArrayList<Integer>> threeSum(int [] nums){
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        HashMap<Integer,Integer> map= new HashMap<>();
//        int n=nums.length;
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                if(map.containsKey(-(nums[i]+nums[j]))){
//                    ArrayList<Integer> temp= new ArrayList<>();
//                    temp.add(nums[i]);
//                    temp.add(nums[j]);
//                    temp.add(-(nums[i]+nums[j]));
//                    Collections.sort(temp);
//                    int ind=map.get(-(nums[i]+nums[j]));
//                    if(!list.contains(temp) && ind!=i && ind!=j){
//                        list.add(temp);
//                    }
//
//                }
//                map.put(nums[j],j);
//            }
//        }
//        return list;
//    }
    /*
    TLE -O(n^2)
    approach-
    store sum of every two elements and their indices in a map
    if negative of an element = sum present in the hashmap , then sum + element= 0
    hence we take out those indexes and add all three elements to a list and then add this list to the final list.
     */
//    public static ArrayList<ArrayList<Integer>> threeSum(int [] nums){
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        HashMap<Integer,ArrayList<Integer>> map= new HashMap<>();
//        int n=nums.length;
//        for(int i=0;i<n-1;i++){
//            for(int j=i+1;j<n;j++){
//                if(map.containsKey(-nums[j])){
//                    ArrayList<Integer> ind= new ArrayList<>(map.get(-nums[j]));
//                    ArrayList<Integer> temp = new ArrayList<>();
//                    temp.add(nums[ind.get(0)]);
//                    temp.add(nums[ind.get(1)]);
//                    temp.add(nums[j]);
//                    Collections.sort(temp);
//                    if(!list.contains(temp) && !ind.contains(j)){
//                        list.add(temp);
//                    }
//                }
//                ArrayList<Integer> sum2 = new ArrayList<>();
//                ArrayList<Integer> index = new ArrayList<>();
//                index.add(i);
//                index.add(j);
//
//                int sum=nums[i]+nums[j];
//                map.put(sum,index);
//            }
//        }
//        return list;
//    }



    //brute - check all the triplets possible and add in list only if it is not present pehle se
//    public static ArrayList<ArrayList<Integer>> threeSum(int [] nums){
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        int n=nums.length;
//        int count=0;
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                for(int k=j+1 ; k<n;k++){
//                    if(nums[i]+nums[j]+nums[k]==0){
//                        ArrayList<Integer> sum= new ArrayList<>();
//                        sum.add(nums[i]);
//                        sum.add(nums[j]);
//                        sum.add(nums[k]);
//                        Collections.sort(sum);
//                        if(!list.contains(sum)) {
//                            list.add(sum);
//                        }
//                    }
//                }
//            }
//        }
//        return list;
//    }
}

