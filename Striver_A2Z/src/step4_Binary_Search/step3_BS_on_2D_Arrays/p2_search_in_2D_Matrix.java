package step4_Binary_Search.step3_BS_on_2D_Arrays;

import java.util.Scanner;

public class p2_search_in_2D_Matrix {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("enter rows");
        int n=in.nextInt();
        System.out.println("enter columns");
        int m= in.nextInt();
        int[][] arr = new int [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=in.nextInt();
            }
        }
        System.out.println("enter target");
        int target=in.nextInt();
        boolean ans=searchMatrix(arr,target);
        System.out.println(ans);
    }

    //thinking of 2D matrix as a 1D array

    public static boolean searchMatrix(int[][] matrix,int target){
        int n=matrix.length;
        int m = matrix[0].length;
        int low=0;
        int high=m*n-1;
        while(low<=high){
            int mid=low +(high-low)/2;
            int row=mid/m;
            int col=mid%m;
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return false;
    }
//    public static boolean searchMatrix(int[][] matrix,int target){
//        int n=matrix.length;
//        int m = matrix[0].length;
//        for(int i=0;i<n;i++){
//            //if range ke bahar hai to skip krdo
//            if(target<matrix[i][0] || target>matrix[i][m-1]){
//                continue;
//            }
//            int low=0;
//            int high=m-1;
//            while(low<=high){
//                int mid=low+(high-low)/2;
//                if(target==matrix[i][mid]){
//                    return true;
//                }
//                else if(target<matrix[i][mid]){
//                    high=mid-1;
//                }
//                else{
//                    low=mid+1;
//                }
//            }
//        }
//        return false;
//    }
}
