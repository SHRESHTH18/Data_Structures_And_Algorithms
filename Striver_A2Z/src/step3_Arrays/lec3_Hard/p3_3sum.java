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
    we use 2 pointer approach
    1 fixed pointer and 2  moving pointers
    First, we will sort the entire array.
We will use a loop(say i) that will run from 0 to n-1. This i will represent the fixed pointer. In each iteration, this value will be fixed for all different values of the rest of the 2 pointers. Inside the loop, we will first check if the current and the previous element is the same and if it is we will do nothing and continue to the next value of i.
After that, there will be 2 moving pointers i.e. j(starts from i+1) and k(starts from the last index). The pointer j will move forward and the pointer k will move backward until they cross each other while the value of i will be fixed.
Now we will check the sum i.e. arr[i]+arr[j]+arr[k].
If the sum is greater, then we need lesser elements and so we will decrease the value of k(i.e. k--).
If the sum is lesser than the target, we need a bigger value and so we will increase the value of j (i.e. j++).
If the sum is equal to the target, we will simply insert the triplet i.e. arr[i], arr[j], arr[k] into our answer and move the pointers j and k skipping the duplicate elements(i.e. by checking the adjacent elements while moving the pointers).
Finally, we will have a list of unique triplets.
     */
    public static ArrayList<ArrayList<Integer>> threeSum(int [] nums){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array to handle duplicates easily

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate elements for 'i' to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    // Skip duplicate elements for 'left' and 'right'
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
                else if (sum < 0) left++;  // Move left pointer to increase sum
                else right--;             // Move right pointer to decrease sum
            }
        }
        return result;
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

