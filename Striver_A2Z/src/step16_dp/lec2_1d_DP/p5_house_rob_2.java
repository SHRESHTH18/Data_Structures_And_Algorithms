package step16_dp.lec2_1d_DP;
import java.util.*;
public class p5_house_rob_2 {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[] leaveLast = Arrays.copyOfRange(nums, 0, n - 1);
        int[] leaveFirst = Arrays.copyOfRange(nums, 1, n);
        return Math.max(houseRob1(leaveFirst),houseRob1(leaveLast));
    }
    public int houseRob1(int[] nums) {
        int n=nums.length;
        int[] dp= new int[n];
        Arrays.fill(dp,-1);
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>=2){
                pick=nums[i]+dp[i-2];
            }
            int not_pick=dp[i-1];

            dp[i]=Math.max(pick,not_pick);
        }
        return dp[n-1];
    }
}
