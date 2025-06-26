package step9_sliding_window_and_2_pointer.lec1_medium;
import java.util.*;
public class p3_fruits_into_baskets {

    //my solution - no extra space
//    public int totalFruits(int[] fruits) {
//        //your code goes here
//        int n= fruits.length;
//        int el1=0;
//        int el2=0;
//        int count1=0;
//        int count2=0;
//        int max=0;
//        int l=0,r=0;
//        while(r<n){
//            if(fruits[r] == el1){
//                count1++;
//                r++;
//            }
//            else if(fruits[r]==el2){
//                count2++;
//                r++;
//            }
//            else{
//                while(l<n && count1>0 && count2>0){
//                    if(fruits[l]==el1){
//                        count1--;
//                    }
//                    else if(fruits[l] == el2){
//                        count2--;
//                    }
//                    l++;
//                }
//            }
//            max=Math.max(max,count1+count2);
//            if(r<n && count1==0){
//                el1=fruits[r];
//            }
//            else if (r<n && count2==0){
//                el2=fruits[r];
//            }
//        }
//        return max;
//    }


    //gpt solution also O(1) as hashmap stores at max 2 elements
    public int totalFruits(int[] fruits) {
        int n = fruits.length;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // If we have more than 2 types of fruits
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
