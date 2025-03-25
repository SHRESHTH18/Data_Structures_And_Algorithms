package step3_Arrays.lec2_Medium;

import java.util.Arrays;
import java.util.Scanner;
public class  p12_rotate_matrix_90 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        System.out.println("enter number of rows");
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        System.out.println("enter matrix row wise");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=in.nextInt();
            }
        }
        rotate(matrix);
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /*
    first transpose the matrix and then reverse every row
     */
    public static void rotate(int[][] matrix){
        int n=matrix.length;
        //transpose
        for (int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                swap(matrix,i,j);
            }
        }
        //reversing each row
        for(int i=0;i<n;i++){
            for(int j=0;j<matrix[i].length/2;j++){
                swap_1D(matrix[i],j,n-j-1);
            }
        }
    }
    public static void swap(int[][] arr,int i,int j){
        int temp=arr[i][j];
        arr[i][j]=arr[j][i];
        arr[j][i]=temp;
    }
    public static void swap_1D(int [] arr,int i , int j ){
        int temp=arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }

    /*
the first row of rotated matrix is first column of original matrix bottom to up
 */
    //TC- O(n^2) SC-O(n^2)
//    public static void rotate(int[][] matrix){
//        int n=matrix.length;
//        int[][] rotated= new int[n][n];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                rotated[i][j]=matrix[n-j-1][i];
//            }
//        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                matrix[i][j]=rotated[i][j];
//            }
//        }
//    }
}
