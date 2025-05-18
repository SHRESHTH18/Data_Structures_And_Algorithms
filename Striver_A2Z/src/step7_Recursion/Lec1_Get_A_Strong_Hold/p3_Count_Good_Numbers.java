package step7_Recursion.Lec1_Get_A_Strong_Hold;
import java.util.Scanner;
public class p3_Count_Good_Numbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        long n = in.nextLong();
        System.out.println(countGoodNumbers(n));
    }

    public static int countGoodNumbers(long n) {
        long  mod = 1000000007;
        return (int)((quickMul(5,(n+1)/2) * quickMul(4,n/2)) % mod);
    }
    public static long quickMul(int x , long n){
        long  mod = 1000000007;
        long ans =1;
        long mul = x;
        while(n>0){
            if(n%2==1){
                ans=(ans*mul)%mod;
            }
            mul= (mul*mul)%mod;
            n/=2;
        }
        return ans;
    }
}
