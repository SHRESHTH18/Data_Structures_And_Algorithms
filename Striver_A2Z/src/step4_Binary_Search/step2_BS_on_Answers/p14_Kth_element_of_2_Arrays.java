package step4_Binary_Search.step2_BS_on_Answers;

import java.util.Scanner;
import java.util.*;
public class p14_Kth_element_of_2_Arrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter k");
        int k=in.nextInt();
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
        int median = kthElement(nums1,nums2,k);
        System.out.println(median);
    }
    //optimised - using binary search
    public static int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int m, int n, int k) {
        if (m > n) return kthElement(b, a, n, m, k);

        int left = k; // length of left half

        // apply binary search:
        int low = Math.max(0, k - n), high = Math.min(k, m);
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            // calculate l1, l2, r1, and r2
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < m) r1 = a.get(mid1);
            if (mid2 < n) r2 = b.get(mid2);
            if (mid1 - 1 >= 0) l1 = a.get(mid1 - 1);
            if (mid2 - 1 >= 0) l2 = b.get(mid2 - 1);

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }

            // eliminate the halves:
            else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; // dummy statement
    }
    public static int kthElement(int[] a, int[] b,int k){
        int n=a.length;
        int m=b.length;
        int count=1;
        int i=0;int j=0;
        int el=0;
        while(i<n && j<m){
            if(a[i]<b[j]){
                if(count==k) el=a[i];
                count++;
                i++;
            }
            else{
                if(count==k) el=b[j];
                count++;
                j++;
            }
        }
        while(i<n){
            if(count==k) el=a[i];
            count++;
            i++;
        }
        while(j<m){
            if(count==k) el=b[j];
            count++;
            j++;
        }
        return el;
    }



}
