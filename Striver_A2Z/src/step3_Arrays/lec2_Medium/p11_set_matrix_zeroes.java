/*
approach -
first store the index of elements that are 0 .Then make the rows and columns of that element also 0
 */

package step3_Arrays.lec2_Medium;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class p11_set_matrix_zeroes {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        System.out.println("enter number of rows");
        int n = in.nextInt();
        System.out.println("enter number of columns");
        int m=in.nextInt();
        int[][] matrix = new int[n][m];
        System.out.println("enter matrix row wise");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=in.nextInt();
            }
        }
        setZeroes(matrix);
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public static void setZeroes(int[][] matrix){
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    list.add(new int[] {i,j});
                }
            }
        }

        for(int k=0;k<list.size();k++){
            int[]arr= list.get(k);
            for(int i=0;i<matrix.length;i++){
                matrix[i][arr[1]] = 0;
            }
            for(int j=0;j<matrix[0].length;j++){
                matrix[arr[0]][j] = 0;
            }
        }
    }
}
