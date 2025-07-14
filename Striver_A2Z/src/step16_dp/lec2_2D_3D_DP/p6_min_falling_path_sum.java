package step16_dp.lec2_2D_3D_DP;
import java.util.*;
public class p6_min_falling_path_sum {
    //djikstra
    class Pair{
        int i;
        int j;
        int dist;
        public Pair(int i, int j, int dist){
            this.i=i;
            this.j=j;
            this.dist=dist;
        }
    }
    public int minFallingPathSumDjikstra(int[][] matrix) {
        int n=matrix.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        for(int i=0;i<n;i++){
            pq.offer(new Pair(0,i,matrix[0][i]));
        }
        int min=Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Pair el=pq.poll();
            int i=el.i;
            int j=el.j;
            int dist=el.dist;
            if(i==n-1){
                min=Math.min(min,dist);
                continue;
            }
            if(j>0)pq.offer(new Pair(i+1,j-1,dist+matrix[i+1][j-1]));
            pq.offer(new Pair(i+1,j,dist+matrix[i+1][j]));
            if(j<n-1)pq.offer(new Pair(i+1,j+1,dist+matrix[i+1][j+1]));
        }
        return min;
    }
    //tabulation
    public int minFallingPathSumTabulation(int[][] matrix) {
        int n=matrix.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        //base case
        for(int i=0;i<n;i++)
            dp[0][i]=matrix[0][i];

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int upl=(int)1e9;
                int upr=(int)1e9;
                if(j>0)upl=matrix[i][j]+dp[i-1][j-1];
                int up=matrix[i][j]+dp[i-1][j];
                if(j<n-1) upr=matrix[i][j]+dp[i-1][j+1];

                dp[i][j]=Math.min(upl,Math.min(up,upr));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,dp[n-1][i]);
        }
        return min;
    }


    //memoization
    public int minFallingPathSumMemoization(int[][] matrix) {
        int n=matrix.length;
        int min=(int)1e9;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            min=Math.min(min,helper(n-1,i,matrix,dp));
        }
        return min;
    }
    public int helper(int i,int j,int[][] matrix,int[][] dp){
        int n=matrix.length;
        if(j<0 || j>=n) return (int)1e9;
        if(i==0) return matrix[0][j];
        if(dp[i][j]!=-1) return dp[i][j];

        int upl=matrix[i][j] +helper(i-1,j-1,matrix,dp);
        int up=matrix[i][j] + helper(i-1,j,matrix,dp);
        int upr=matrix[i][j] + helper(i-1,j+1,matrix,dp);

        return dp[i][j]=Math.min(upl,Math.min(up,upr));
    }

    //recursive
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int min=(int)1e9;
        for(int i=0;i<n;i++){
            min=Math.min(min,helper(n-1,i,matrix));
        }
        return min;
    }
    public int helper(int i,int j,int[][] matrix){
        int n=matrix.length;
        //j ki statement pehle aaegi bcoz i-1,j-1 krte hue i=0,j=-1 ho skta jisme matrix[0][-1] return krna padega which will give error
        if(j<0 || j>=n) return (int)1e9;//min path h to if bound se bahar gaya to infinite distance
        if(i==0) return matrix[0][j];


        int upl=matrix[i][j] +helper(i-1,j-1,matrix);
        int up=matrix[i][j] + helper(i-1,j,matrix);
        int upr=matrix[i][j] + helper(i-1,j+1,matrix);

        return Math.min(upl,Math.min(up,upr));
    }
}
