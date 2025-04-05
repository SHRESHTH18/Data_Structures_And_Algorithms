package step4_Binary_Search.step2_BS_on_Answers;
import java.util.*;
public class p13_Median_of_2_Sorted_Arrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n1");
        int n1=in.nextInt();
        int[] nums1=new int[n1];
        System.out.println("enter array1");
        for(int i=0;i<n1;i++){
            nums1[i]=in.nextInt();
        }
        System.out.println("enter n2");
        int n2=in.nextInt();
        int[] nums2 = new int [n2];
        System.out.println("enter array2");
        for(int i=0;i<n2;i++){
            nums2[i]=in.nextInt();
        }
        double median = findMedianSortedArrays(nums1,nums2);
        System.out.println(median);
    }
    public static double findMedianSortedArrays(int[] nums1,int[] nums2){
        int n1 = nums1.length, n2 = nums2.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int n = n1 + n2; //total length
        int left = (n1 + n2 + 1) / 2; //length of left half
        //apply binary search:
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            //calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; //dummy statement
    }

//    public static double findMedianSortedArrays(int[] nums1,int[] nums2){
//        int n1=nums1.length;
//        int n2=nums2.length;
//        int n=n1+n2;
//        int el1=0;
//        int el2=0;
//        int count=0;
//        int i=0;int j=0;
//        while(i<n1 && j<n2){
//
//            if(nums1[i]<=nums2[j]){
//                if(count==n/2) el2=nums1[i];
//                if(count==n/2 -1) el1=nums1[i];
//                count++;
//                i++;
//            }
//            else{
//                if(count==n/2) el2=nums2[j];
//                if(count==n/2 -1) el1=nums2[j];
//                count++;
//                j++;
//            }
//        }
//        while(i<n1){
//            if(count==n/2) el2=nums1[i];
//            if(count==n/2 -1) el1=nums1[i];
//            count++;
//            i++;
//        }
//        while(j<n2){
//            if(count==n/2) el2=nums2[j];
//            if(count==n/2 -1) el1=nums2[j];
//            count++;
//            j++;
//        }
//        if(n%2==0) return (double)(el1+el2)/2.0;
//        return el2;
//    }
}
