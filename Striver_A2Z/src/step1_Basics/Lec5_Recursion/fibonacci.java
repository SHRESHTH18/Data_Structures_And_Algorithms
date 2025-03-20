package step1_Basics.Lec5_Recursion;
import java.util.Scanner;


public class fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(fib(n));
    }
    //8ms
//    static int fib(int n){
//        if (n==0 || n==1){
//            return n;
//        }
//        return fib(n-1)+fib(n-2);
//    }

    //0 ms
    static int fib(int n){
        int arr[]=new int[n+1];
        for(int i=0;i<=n;i++){
            if(i==0){arr[0]=0;}
            else if(i==1){arr[1]=1;}
            else{
                arr[i]=arr[i-1]+arr[i-2];}
        }
        return arr[n];
    }


}
