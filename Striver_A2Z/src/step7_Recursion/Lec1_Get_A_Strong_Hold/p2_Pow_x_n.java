package step7_Recursion.Lec1_Get_A_Strong_Hold;
import java.util.Scanner;
public class p2_Pow_x_n {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter x");
        int x= in.nextInt();
        System.out.println("enter n");
        int n= in.nextInt();
        System.out.println(myPow(x,n));
    }
    public static double myPow(double x, int m) {
        double ans =1.0;

        long n =m;

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        while(n>0){
            if(n%2==0){
                n=n/2;
                x=x*x;
            }
            else{
                n=n-1;
                ans=ans*x;
            }
        }

        return ans;
    }

}
