package step3_Arrays.lec3_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p7_merge_intervals {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter number of intervals");
        int n=in.nextInt();
        int[][] arr = new int[n][2];
        System.out.println("enter the intervals");
        for(int i=0;i<n;i++){
            arr[i][0]=in.nextInt();
            arr[i][1]= in.nextInt();
        }
        int[][] merge = merge(arr);
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(merge[i]));
        }
    }
    public static int[][] merge(int[][] intervals){
        int n = intervals.length;
        ArrayList<int[]> temp = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i=0;i<n;i++){
            if(temp.size()==0 || intervals[i][0]>temp.get(temp.size()-1)[1]){
                    temp.add(intervals[i]);
            }
            else{
                temp.get(temp.size() -1)[1] = Math.max(temp.get(temp.size() -1)[1],intervals[i][1]);
            }
        }


        int[][] merge = temp.toArray(new int[temp.size()][2]);
        return merge;
    }


//    public static int[][] merge(int[][] intervals){
//        int n = intervals.length;
//        ArrayList<int[]> temp = new ArrayList<>();
//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//
//        for (int i = 0; i < n; i++) {
//            int start = intervals[i][0];
//            int end = intervals[i][1];
//
//            if (temp.size() != 0 && end <= temp.get(temp.size() - 1)[1]) {
//                continue;
//            }
//
//            for (int j = i + 1; j < n; j++) {
//                if (intervals[j][0] <= end) {
//                    end = Math.max(end, intervals[j][1]);
//                } else {
//                    break;
//                }
//            }
//            temp.add(new int[]{start, end});
//        }
//
//        int[][] merge = temp.toArray(new int[temp.size()][2]);
//        return merge;
//    }
}
