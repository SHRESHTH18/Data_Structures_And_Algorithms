package step8_stack_and_queue.lec3_monotonic_stack_queue;

public class p1_next_greater_element {


    //brute
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int[] ans = new int[nums1.length];
//        for(int i=0;i<nums1.length;i++){
//            int index=0;
//            for(int j=0;j<nums2.length;j++){
//                if(nums1[i]==nums2[j]){
//                    index=j;
//                    break;
//                }
//            }
//            int flag=0;
//            for(int j=index;j<nums2.length;j++){
//                if(nums2[j]>nums1[i]){
//                    ans[i]=nums2[j];
//                    flag=1;
//                    break;
//                }
//            }
//            if (flag==0){
//                ans[i]=-1;
//            }
//        }
//        return ans;
//    }
}
