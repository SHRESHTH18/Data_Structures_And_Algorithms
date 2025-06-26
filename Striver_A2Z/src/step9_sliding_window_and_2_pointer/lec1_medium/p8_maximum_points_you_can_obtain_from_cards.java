package step9_sliding_window_and_2_pointer.lec1_medium;

public class p8_maximum_points_you_can_obtain_from_cards {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int sum=0;

        for(int i=n-k;i<n;i++){
            sum+=cardPoints[i];
        }
        int max=sum;
        if(k==n){
            return sum;
        }
        int l=n-k;
        for(int r=n;r<n+k;r++){
            sum+=cardPoints[r%n];
            sum-=cardPoints[l%n];
            l++;
            max=Math.max(sum,max);
        }
        return max;
    }
}
