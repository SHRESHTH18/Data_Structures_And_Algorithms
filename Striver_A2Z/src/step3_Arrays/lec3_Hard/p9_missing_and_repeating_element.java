package step3_Arrays.lec3_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class p9_missing_and_repeating_element {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n= in.nextInt();
        System.out.println("enter array");
        int [] nums = new int [n];
        for(int i=0;i<n;i++){
            nums[i]= in.nextInt();
        }
        ArrayList<Integer> list = findTwoElement(nums);
        System.out.println(list);
    }
    /*
    using maths
    sum of first n elements = n(n+1)/2 =Sn
    sum of squares = n(n+1)(2n+1)/6 =S2n
    S=sum of elements of array
    S2= sum of squares of elements of array
    Assume the repeating number to be X and the missing number to be Y.
    S-Sn= X-Y  -----1
    S2-S2n = X^2 -Y^2 ------2

    dividing the equation 2 by equation 1 we will get X+Y  - equation 3
    hence we can find values of X and Y

     */

    public static ArrayList<Integer> findTwoElement(int[] arr){
        int n= arr.length;
        int xr=0;
        for(int i=0;i<n;i++){
            xr=xr^arr[i];
            xr=xr^(i+1);
        }
        int bitno=0;
        while(true){
            if((xr & (1<<bitno)) != 0){
                break;
            }
            bitno++;
        }
        int zero=0;
        int one =0;
        for(int i=0;i<n;i++){
            //part of 1 club
            if((arr[i] & (1<<bitno)) !=0 ){
                one = one^arr[i];
            }
            //part of 0 club
            else{
                zero=zero^arr[i];
            }
            if((i & (1<<bitno)) !=0 ){
                one = one^i;
            }
            //part of 0 club
            else{
                zero=zero^i;
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]==zero){
                count++;
            }
        }
        if(count ==2){
            return new ArrayList<>(Arrays.asList(zero, one));
        }
        return new ArrayList<>(Arrays.asList(one,zero));

    }

    /*
    WE CAN ALSO USE HASH ARRAY INSTEAD OF HASHSET
    store all numbers in hashset , if number already present in hashset -> repeating
    after adding every element , we check which element is absent
     */
//    public static ArrayList<Integer> findTwoElement(int[] arr){
//        int[] temp=new int[2];
//        HashSet<Integer> set = new HashSet<>();
//        int n=arr.length;
//        for(int i=0;i<n;i++){
//            if(set.contains(arr[i])){
//                temp[0]=arr[i];
//            }
//            set.add(arr[i]);
//        }
//        for(int i=1;i<=n;i++){
//            if(!set.contains(i)){
//                temp[1]=i;
//            }
//        }
//
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(temp[0]);
//        list.add(temp[1]);
//        return list;
//    }
}
