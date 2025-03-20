package step3_Arrays.lec2_Medium;
import java.util.Scanner;
import java.util.HashMap;
public class p3_majority_element {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int a= majorityElement(arr);
        System.out.println(a);
    }

    public static int majorityElement(int[] nums){
        int maj=-1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                int val=map.get(i);
                map.replace(i,val+1);
            }
            else{
                map.put(i,1);
            }
        }
        for(int key:map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                maj = key;
                break;
            }
        }
        return maj;
    }
}
