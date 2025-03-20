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
    public static ArrayList<ArrayList<Integer>> generate(int numRows){
        ArrayList<ArrayList<Integer>> triangle= new ArrayList<>();
        for(int i = 1;i<=numRows;i++){
            triangle.add(new ArrayList<>());
        }
        for(int i=0;i<numRows;i++){
            if(i==0){
                triangle.get(0).add(1);
            }
            else if(i==1){
                triangle.get(1).add(1);
                triangle.get(1).add(1);
            }
            else{
                triangle.get(i).add(1);
                int k=0;
                for(int j=1;j<i;j++){
                    triangle.get(i).add(triangle.get(i-1).get(k)+triangle.get(i-1).get(k+1));
                    k++;
                }
                triangle.get(i).add(1);
            }
        }
        return triangle;
    }

}
