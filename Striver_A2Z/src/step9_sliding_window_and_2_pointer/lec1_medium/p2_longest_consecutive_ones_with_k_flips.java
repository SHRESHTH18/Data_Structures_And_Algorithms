package step9_sliding_window_and_2_pointer.lec1_medium;

public class p2_longest_consecutive_ones_with_k_flips {public int longestOnes(int[] nums, int k) {
    int n= nums.length;
    int max=0;
    int l = 0 ;
    int r = 0;
    int count=0;
    while(r<n){
        while(k>0 && r<n){
            if(nums[r]==1){
                count++;
                r++;
            }
            //flipping 0 to 1 and counting it as 1
            else{
                k--;
                count++;
                r++;
            }
        }

        //the 1s which are after the last flipped 0 should be added as well
        while(r<n && nums[r]==1){
            r++;
            count++;
        }
        max=Math.max(max,count);

        //l pointer ko aage badhao till 0 encounter na hojae
        while(k<=0 && l<n){
            if(nums[l]==0){
                k++;
            }
            l++;
            count--;
        }
    }
    return max;
}
}
