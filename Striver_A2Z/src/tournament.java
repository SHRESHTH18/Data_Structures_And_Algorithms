
import java.util.*;
public class tournament {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();


        for(int a=0;a<t;a++){
            int n =in.nextInt();
            int j=in.nextInt();
            int k=in.nextInt();
            int[] strength = new int[n];
            for(int i=0;i<n;i++){
                strength[i]=in.nextInt();
            }

            if(k!=1){
                System.out.println("YES");
            }
            else{
                int max=0;
                for(int i=0;i<n;i++){
                    max=Math.max(max,strength[i]);
                }
                if(strength[j-1]==max){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }

        }



    }
}
