package step3_Arrays.lec2_Medium;
/*
the first row of rotated matrix is first column of original matrix bottom to up
 */
import java.util.Arrays;
import java.util.Scanner;
public class p12_rotate_matrix_90 {
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
    public static void rotate(int[][] matrix){
        int n=matrix.length;
        int[][] rotated= new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                rotated[i][j]=matrix[n-j-1][i];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=rotated[i][j];
            }
        }
    }
}
