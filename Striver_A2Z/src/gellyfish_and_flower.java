import java.util.Scanner;
public class gellyfish_and_flower {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int[] a= new int[n];//gelly
        int[] b= new int[n];//flower
        int[] c= new int[n];//gk
        int[] d= new int[n];//fk
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
            b[i]=in.nextInt();
            c[i]=in.nextInt();
            d[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
            if(c[i]>=d[i]){
                {
                    if(a[i]<d[i] && b[i]>a[i]){
                        System.out.println("Flower");
                    }
                    else{
                        System.out.println("Gellyfish");
                    }
                }
            }
            else{
                if(b[i]<=c[i] && a[i]>=b[i]){
                    System.out.println("Gellyfish");
                }
                else{
                    System.out.println("FLower");
                }
            }
        }
    }
}
