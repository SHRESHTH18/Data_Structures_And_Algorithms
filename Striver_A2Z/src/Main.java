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
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println(numRabbits(arr));
    }
    public static int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n=answers.length;
        for(int i=0;i<n;i++){
            map.put(answers[i],map.getOrDefault(answers[i],0)+1);
        }
        int count=0;
        for(int key:map.keySet()){
            int mul=(int)Math.ceil((double)map.get(key)/(double)(key+1));

            count = count+ (1 + key)*mul;
        }
        return count;
    }
}