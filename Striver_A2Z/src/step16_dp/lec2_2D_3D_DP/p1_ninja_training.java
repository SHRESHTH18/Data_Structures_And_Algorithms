package step16_dp.lec2_2D_3D_DP;
import java.util.*;
public class p1_ninja_training {

    //space optimisation
    public int maximumPoints(int arr[][]) {
        int n = arr.length;
        int[] prev = new int[4];

        // Base case for day 0
        prev[0] = Math.max(arr[0][1], arr[0][2]);
        prev[1] = Math.max(arr[0][0], arr[0][2]);
        prev[2] = Math.max(arr[0][0], arr[0][1]);
        prev[3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));

        for (int day = 1; day < n; day++) {
            int[] curr = new int[4];
            for (int last = 0; last < 4; last++) {
                int maxi = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int points = arr[day][task] + prev[task];
                        maxi = Math.max(maxi, points);
                    }
                }
                curr[last] = maxi;
            }
            prev = curr;  // Move to next day
        }

        return prev[3];  // Answer is when no restriction on previous task
    }
    //tabulation
//    public int maximumPoints(int arr[][]) {
//        // code here
//        int n=arr.length;
//        int[][] dp = new int[n][4];
//        for(int i=0;i<n;i++){
//            Arrays.fill(dp[i],-1);
//        }
//
//        dp[0][0]=Math.max(arr[0][1],arr[0][2]);
//        dp[0][1]=Math.max(arr[0][0],arr[0][2]);
//        dp[0][2]=Math.max(arr[0][1],arr[0][0]);
//        dp[0][3]=Math.max(arr[0][1],Math.max(arr[0][2],arr[0][0]));
//
//        for(int day=1;day<n;day++){
//            for(int last=0;last<4;last++){
//                int maxi=0;
//                for(int task=0;task<3;task++){
//                    if(task!=last){
//                        int points=arr[day][task]+dp[day-1][task];
//                        maxi=Math.max(maxi,points);
//                    }
//                }
//                dp[day][last]=maxi;
//            }
//
//        }
//        return dp[n-1][3];
//
//    }

    //mempisation
//    public int maximumPoints(int arr[][]) {
//        // code here
//        int days=arr.length;
//        int[][] dp = new int[days][4];
//        for(int i=0;i<days;i++){
//            Arrays.fill(dp[i],-1);
//        }
//        return helper(days-1,3,arr,dp);
//
//    }
//    public int helper(int day,int skill,int[][] arr,int[][] dp){
//        if (day == 0) {
//            int max = 0;
//            for (int i = 0; i < 3; i++) {
//                if (i != skill) {
//                    max = Math.max(max, arr[0][i]);
//                }
//            }
//            return max;
//        }
//        if(dp[day][skill]!=-1) return dp[day][skill];
//        int max=0;
//        for(int i=0;i<3;i++){
//            if(i==skill) continue;
//            int next=arr[day][i]+helper(day-1,i,arr,dp);
//            max=Math.max(max,next);
//        }
//        return dp[day][skill]=max;
//    }

    //recursive-my solution
//    public int maximumPoints(int arr[][]) {
//        // code here
//        int days=arr.length;
//        return helper(days-1,-1,arr);
//
//    }
//    public int helper(int day,int skill,int[][] arr){
//        if (day == 0) {
//            int max = 0;
//            for (int i = 0; i < 3; i++) {
//                if (i != skill) {
//                    max = Math.max(max, arr[0][i]);
//                }
//            }
//            return max;
//        }
//        int max=0;
//        for(int i=0;i<3;i++){
//            if(i==skill) continue;
//            int next=arr[day][i]+helper(day-1,i,arr);
//            max=Math.max(max,next);
//        }
//        return max;
//    }
}
