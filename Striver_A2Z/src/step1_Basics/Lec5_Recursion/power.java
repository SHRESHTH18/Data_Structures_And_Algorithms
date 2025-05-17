package step1_Basics.Lec5_Recursion;
import java.util.Scanner;
public class power {
    public static void main(String[] args) {
        System.out.println("enter base");
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        System.out.println("enter power");
        int p = in.nextInt();
        System.out.println(RecursivePower(n,p));
    }
    static int RecursivePower(int n, int p) {
        // add your code here
        if (p==0) return 1;
        return n*RecursivePower(n,p-1);
    }
}

