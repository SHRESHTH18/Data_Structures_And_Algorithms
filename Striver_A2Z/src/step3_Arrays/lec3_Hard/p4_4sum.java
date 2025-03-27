package step3_Arrays.lec3_Hard;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class p4_4sum {
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
        ArrayList<ArrayList<Integer>> list= fourSum(arr,target);
        System.out.println(list);
    }

    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums,int target){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        HashMap<Long, Integer> map = new HashMap<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            for(int j=n-1;j>2;j--){
                int a=i+1;
                int b=j-1;
                while(a<b){
                    long sum=(long)nums[i]+ (long)nums[j]+ (long)nums[a]+ (long)nums[b];
                    if(sum<(long)target)
                        a++;
                    else if(sum>(long)target)
                        b--;
                    else {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[a]);
                        temp.add(nums[b]);
                        temp.add(nums[j]);
                        if(!list.contains(temp)){
                            list.add(temp);
                        }
                        a++;
                        b--;
                    }
                }
            }
        }
        return list;
    }

    /*
    TLE
    see from hashmap
     */


//    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums,int target){
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        HashMap<Long, Integer> map = new HashMap<>();
//        int n = nums.length;
//
//        for (int a = 0; a < n; a++) {
//            for (int b = a + 1; b < n; b++) {
//                for (int c = b + 1; c < n; c++) {
//                    long remaining = (long) target - (long) nums[a] - (long) nums[b] - (long) nums[c];
//                    System.out.println(a);
//                    System.out.println(b);
//                    System.out.println(c);
//                    System.out.println(remaining);
//                    if (map.containsKey(remaining) && map.get(remaining) != a
//                            && map.get(remaining) != b && map.get(remaining) != c) {
//
//                        ArrayList<Integer> temp = new ArrayList<>();
//                        temp.add(nums[a]);
//                        temp.add(nums[b]);
//                        temp.add(nums[c]);
//                        temp.add((int) remaining);
//                        Collections.sort(temp);
//
//                        if (!list.contains(temp)) {
//                            list.add(temp);
//                        }
//                    }
//                    map.put((long)nums[c], c);
//                }
//            }
//        }
//        return list;
//    }


    //brute force- check all four elements pairs -O(n^4)
//    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums,int target){
//        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
//        int n=nums.length;
//        for(int a=0;a<n;a++){
//            for(int b=a+1;b<n;b++){
//                for(int c=b+1;c<n;c++){
//                    for(int d=c+1;d<n;d++){
//                        if(nums[a]+nums[b]+nums[c]+nums[d]==target){
//                            ArrayList<Integer> temp=new ArrayList<>();
//                            temp.add(nums[a]);
//                            temp.add(nums[b]);
//                            temp.add(nums[c]);
//                            temp.add(nums[d]);
//                            Collections.sort(temp);
//                            if(!list.contains(temp)){
//                                list.add(temp);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return list;
//    }
}
