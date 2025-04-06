package step4_Binary_Search.step3_BS_on_2D_Arrays;

import java.util.Scanner;

public class p3_search_in_2D_matrix_sorted_columnwise {
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

    public static boolean searchMatrix(int[][] matrix,int target){
        int n=matrix.length;
        int m = matrix[0].length;
        int row=0;
        int col=m-1;
        while(row<n && col>=0){
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                row++;
            }
            else{
                col--;
            }
        }
        return false;
    }
//    public static boolean searchMatrix(int[][] matrix,int target){
//        int n=matrix.length;
//        int m = matrix[0].length;
//        for(int i=0;i<m;i++){
//            //if range ke bahar hai to skip krdo
//            if(target<matrix[0][i] || target>matrix[n-1][i]){
//                continue;
//            }
//            int low=0;
//            int high=n-1;
//            while(low<=high){
//                int mid=low+(high-low)/2;
//                if(target==matrix[mid][i]){
//                    return true;
//                }
//                else if(target<matrix[mid][i]){
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
