package step8_stack_and_queue.lec3_monotonic_stack_queue;

public class p5_trapping_rain_water {

    public int trap(int[] height) {
        int n = height.length;
        int water =0;
        int left_max=0;
        int right_max=0;
        int l=0;
        int r=n-1;
        while(l<r){
            if(height[l]<=height[r]){
                if(height[l]>=left_max){
                    left_max=height[l];
                }
                else{
                    water=water + (left_max-height[l]);
                }
                l++;
            }
            else{
                if(height[r]>=right_max){
                    right_max=height[r];
                }
                else{
                    water=water + (right_max-height[r]);
                }
                r--;
            }
        }
        return water;
    }
    //O(3N)
//    public int trap(int[] height) {
//        int n = height.length;
//        int water =0;
//        int[] prefix = new int[n];
//        prefix[0]=height[0];
//        for(int i=1;i<n;i++){
//            prefix[i]=Math.max(height[i],prefix[i-1]);
//        }
//        int[] suffix = new int[n];
//        suffix[n-1]=height[n-1];
//        for(int i =n-2;i>=0;i--){
//            suffix[i]=Math.max(suffix[i+1],height[i]);
//        }
//
//        for(int i=0;i<n;i++){
//            int level= Math.min(prefix[i],suffix[i]);
//            water += (level-height[i]);
//        }
//        return water;
//    }
}
