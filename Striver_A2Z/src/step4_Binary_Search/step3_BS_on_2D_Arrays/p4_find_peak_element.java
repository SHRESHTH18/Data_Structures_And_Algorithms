package step4_Binary_Search.step3_BS_on_2D_Arrays;

import java.util.Scanner;
import java.util.*;

public class p4_find_peak_element {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("enter rows");
        int n=in.nextInt();
        System.out.println("enter columns");
        int m= in.nextInt();
        int[][] arr = new int [n][m];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=in.nextInt();
            }
        }
        int[]  ans=findPeakGrid(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] findPeakGrid(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;
        int[] ans=new int[2];
        int low=0;
        int high=m-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int row=max(mat,mid);
            int left= mid-1>=0 ? mat[row][mid-1]:-1;
            int right = mid+1 <m?mat[row][mid+1]:-1;
            System.out.println("mid:"+mid);
            System.out.println("left:"+left);
            System.out.println("right:"+right);
            if(mat[row][mid]>left && mat[row][mid]>right){
                System.out.println("peak");
                ans[0]=row;
                ans[1]=mid;
                return ans;
            }
            else if(mat[row][mid]<left) high=mid-1;
            else low=mid+1;
        }
        ans[0]=-1;
        ans[1]=-1;
        return ans;
    }
    public static int max(int[][] mat,int col){
        int n=mat.length;
        int max=Integer.MIN_VALUE;
        int ind=0;
        for(int i=0;i<n;i++){
            if(mat[i][col]>max){
                ind=i;
                max=mat[i][col];
            }
        }
        return ind;
    }
}
