package step1_Basics.Lec5_Recursion;

import java.util.Scanner;

public class print_1_to_n {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n= in.nextInt();
        print(n);
    }
    public static void print(int n){
        if(n==0) return;
        print(n-1);
        System.out.print(n+" ");
    }
}
