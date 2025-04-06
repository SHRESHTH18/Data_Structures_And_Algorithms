package step4_Binary_Search.step3_BS_on_2D_Arrays;
import java.util.*;
public class p1_row_with_max_1s {
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
        int  ans=rowWithMax1s(arr);
        System.out.println(ans);

    }
    //since the rows are sorted , we can use binary search .
    public static int rowWithMax1s(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;
        int max=0;
        int ans=0;

        for(int i=0;i<n;i++){
            int count=0;
            int low=0;
            int high=m-1;
            while(low<=high){
                int mid=low + (high-low)/2;
                if(arr[i][mid]==1){
                    count=m-mid;
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            if(count>max){
                max=count;
                ans=i;
            }
        }
        return ans;
    }
//    public static int rowWithMax1s(int[][] arr){
//        int n=arr.length;
//        int m=arr[0].length;
//        int max=0;
//        int ans=0;
//
//        for(int i=0;i<n;i++){
//            int count=0;
//            for(int j=0;j<m;j++){
//                if(arr[i][j]==1){
//                    count++;
//                }
//            }
//            if(count>max){
//                max=count;
//                ans=i;
//            }
//        }
//        return ans;
//    }
}
