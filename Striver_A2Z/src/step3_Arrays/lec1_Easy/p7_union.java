package step3_Arrays.lec1_Easy;

import java.util.ArrayList;
import java.util.Scanner;

public class p7_union {
    public static void main(String[] args) {
        System.out.println("enter size of array");
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int [] a= new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        int [] b= new int[m];
        System.out.println("enter array");
        for(int i=0;i<m;i++){
            b[i]=in.nextInt();
        }
        System.out.println(findUnion(a,b));
    }
    static ArrayList<Integer> findUnion(int[] a , int[] b){
        ArrayList<Integer> list = new ArrayList<>();
        int i=0,j=0,ind=0;
        list.add(Integer.MIN_VALUE);
        while(i<a.length && j<b.length){
            if(a[i]==b[j]){
                if(a[i]>list.get(ind)){
                    list.add(a[i]);
                    ind++;
                }
                System.out.println(list);
                i++;j++;
            }
            else if(a[i]<b[j]){
                if(a[i]>list.get(ind)){
                    list.add(a[i]);
                    ind++;
                }
                i++;
                System.out.println(list);
            }
            else{
                if(b[j]>list.get(ind)){
                    list.add(b[j]);
                    ind++;
                }
                j++;
                System.out.println(list);
            }

        }
        while(i<a.length){
            if(a[i]>list.get(ind)){
                list.add(a[i]);
                ind++;
            }
            i++;
        }
        while(j<b.length){
            if(b[j]>list.get(ind)){
                list.add(b[j]);
                ind++;
            }
            j++;

        }
        list.remove(0);
        return list;
    }
}
