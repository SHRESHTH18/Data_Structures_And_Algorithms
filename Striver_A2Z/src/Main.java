// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.HashSet;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter length");
        int n= in.nextInt();
        System.out.println("enter array");
//        int[] arr = new int[n];
//        for(int i=0;i<n;i++){
//            arr[i]=in.nextInt();
//        }
        gfSeries(n);
        ArrayList<Integer> list = new ArrayList<>();
    }
    static void gfSeries(int N) {
        int[] arr = new int[N];
        if (N >= 1) {
            arr[0] = 0;
            System.out.print(arr[0] + " ");
        }
        if (N >= 2) {
            arr[1] = 1;
            System.out.print(arr[1] + " ");
        }
        for (int i = 2; i < N; i++) {
            arr[i] = (int)(Math.pow(arr[i - 2], 2)) - arr[i - 1];
            System.out.print(arr[i] + " ");
        }
    }
}