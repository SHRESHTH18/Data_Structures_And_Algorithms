package step3_Arrays.lec2_Medium;
/*
approach
draw on pen paper and find out how will the iterator move
k : loop number
k=0 outer loop
k=1 inner loop and so on
first line : k,k->k,m-k-1
last column : k+1,m-k-1 -> n-k-1,m-k-1
last line : n-k-1,m-k-2 -> n-k-1,k
first column : n-k-1,k->k+1,k
repeat this all elements are covered
 */
import java.util.Scanner;
import java.util.ArrayList;

public class p13_spiral_matrix {
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
        ArrayList<Integer> list =spiralOrder(matrix);
        System.out.println(list);
    }
    public static ArrayList<Integer> spiralOrder(int[][] matrix){
        ArrayList<Integer> list= new ArrayList<>();
        int count=0;
        int n = matrix.length;
        int m= matrix[0].length;
        int k=0;
        while(count<m*n){
            for(int j=k;j<=m-k-1;j++){
                if(list.size()<m*n){
                    list.add(matrix[k][j]);
                    count++;
                }
            }
            for(int i=k+1;i<=n-k-1;i++){
                if(list.size()<m*n){
                    list.add(matrix[i][m-k-1]);
                    count++;
                }
            }
            for(int j=m-k-2;j>=k;j--){
                if(list.size()<m*n){
                    list.add(matrix[n-k-1][j]);
                    count++;
                }
            }
            for(int i=n-k-2;i>=k+1;i--){
                if(list.size()<m*n){
                    list.add(matrix[i][k]);
                    count++;
                }
            }
            k++;
        }
        return list;
    }
}
