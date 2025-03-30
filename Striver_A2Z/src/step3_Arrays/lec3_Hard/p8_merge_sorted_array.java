package step3_Arrays.lec3_Hard;

import java.util.Arrays;
import java.util.Scanner;

public class p8_merge_sorted_array {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("enter m");
        int m=in.nextInt();
        System.out.println("enter n");
        int n=in.nextInt();
        int[] nums1 = new int[m+n];
        int[] nums2 = new int[n];
        System.out.println("enter nums1");
        for(int i=0;i<m;i++){
            nums1[i]=in.nextInt();
        }
        System.out.println("enter nums2");
        for(int i=0;i<n;i++){
            nums2[i]=in.nextInt();
        }
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
    /*
    Leetcode optimal answer
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;
        int p2=n-1;
        int p=m+n-1;
        while(p1>=0 && p2>=0){
            if(nums1[p1]>nums2[p2]){
                nums1[p]=nums1[p1];
                p1--;
            }
            else{
                nums1[p]=nums2[p2];
                p2--;
            }
            p--;
        }
        while(p2>=0){
            nums1[p]= nums2[p2];
            p2--;
            p--;
        }
    }

    //striver's answer - arr 1 me saare chhote elements hone chahiye , and right array me saare bade elements hone chahiye
    //fir dono arrays ko sort krdo
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int left=n-1;
//        int right =0;
//        while(left>=0 && right<m){
//            if(nums1[left]>nums2[right]){
//                swap(nums1,nums2,left,right);
//                left--;
//                right++;
//            }
//            else{
//                break;
//            }
//        }
//        Arrays.sort(nums1,0,m);
//        Arrays.sort(nums2);
//    }
//    public static void swap(int[] arr1,int[] arr2,int left,int right){
//        int temp=arr1[left];
//        arr1[left]=arr2[right];
//        arr2[right]=temp;
//    }
    /*
    MY ANSWER WHICH IS CORRECT FOR THE LEETCODE
    nums1 me jitna bhi extra space h pehle usko int.max krdo
    then compare elements of nums1 and nums2
    if nums2 ka element bada then simply i++
    if nums1 ka element bada , we shift right nums1 by one place
     */
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//
//        for(int i=m;i<n+m;i++){
//            nums1[i]=Integer.MAX_VALUE;
//        }
//        int i=0;
//        int j=0;
//        while(i<m+n && j<n){
//            System.out.println("NUMS1="+nums1[i]+"NUMS2="+nums2[j]);
//            if(nums1[i]<=nums2[j]){
//                i++;
//            }
//            else if(nums1[i]>nums2[j]){
//                shift(nums1,i);
//                nums1[i]=nums2[j];
//                i++;
//                j++;
//            }
//        }
//        while(j<n){
//            nums1[i]=nums2[j];
//            i++;j++;
//        }
//    }
    public static void shift(int[] nums1,int i){
        int n=nums1.length;
        for(int j=n-1;j>i;j--){
            nums1[j]=nums1[j-1];
        }
    }
}
