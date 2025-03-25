package step3_Arrays.lec3_Hard;
import java.util.Scanner;
import java.util.ArrayList;
public class p1_pascals_triangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter number of rows");
        int n=in.nextInt();
        ArrayList<ArrayList<Integer>> triangle= new ArrayList<>();
        triangle = generate(n);
        System.out.println(triangle);
    }

    /*
    6th row of pascals triangle - 1 5 10 10 5 1
    first and last element always 1
    then 5/1 , 5*4 / 1*2 ,  5*4*3 / 1*2*3 , 5*4*3*2 / 1*2*3*4
    multiplying by (row - col) / col
     */
    public static ArrayList<ArrayList<Integer>> generate(int numRows){
        ArrayList<ArrayList<Integer>> triangle= new ArrayList<>();
        for(int i = 1;i<=numRows;i++){
            triangle.add(new ArrayList<>());
        }
        // for nth row , use a for loop on column and iterate over R of NCR
        for(int i=0;i<numRows;i++){
            triangle.get(i).add(1);
            int ans=1;
            for(int j=0;j<i;j++){
                ans=ans*(i-j);
                ans=ans/(j+1);
                triangle.get(i).add(ans);
            }
        }
        return triangle;
    }

    //not good to calculate factorial .
//    public static int factorial(int n){
//        int fact=1;
//        for(int i=2;i<=n;i++){
//            fact*= i;
//        }
//        return fact;
//    }

    // for any element ,element = (n-1) C (r-1) = n!/ [r! * (n-r)!]
    public static int NCR(int n,int r){
        int res=1;
        for(int i=0;i<r;i++){
            res=res * (n-i);
            res=res/(i+1);
        }
        return res;
    }
    /*
    approach
    saw the pattern ki first and last element =1
    for middle elements upar wali row ka koi to 2 element(relation nikal lo) ka sum
     */
//    public static ArrayList<ArrayList<Integer>> generate(int numRows){
//        ArrayList<ArrayList<Integer>> triangle= new ArrayList<>();
//        for(int i = 1;i<=numRows;i++){
//            triangle.add(new ArrayList<>());
//        }
//        for(int i=0;i<numRows;i++){
//            if(i==0){
//                triangle.get(0).add(1);
//            }
//            else if(i==1){
//                triangle.get(1).add(1);
//                triangle.get(1).add(1);
//            }
//            else{
//                triangle.get(i).add(1);
//                int k=0;
//                for(int j=1;j<i;j++){
//                    triangle.get(i).add(triangle.get(i-1).get(k)+triangle.get(i-1).get(k+1));
//                    k++;
//                }
//                triangle.get(i).add(1);
//            }
//        }
//        return triangle;
//    }

}
