package step6_LinkedList.lec4_medium_problems_on_double_LL;
import java.util.*;
public class p2_pairs_with_given_sum {


    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        Node left=head;
        Node right=head;
        int len=1;
        while(right.next!=null){
            len++;
            right=right.next;
        }
        while(len>1){
            int sum=right.data+left.data;
            if(sum==target){
                ArrayList<Integer> temp= new ArrayList<>();
                temp.add(left.data);
                temp.add(right.data);
                list.add(temp);
                left=left.next;
                right=right.prev;
                len=len-2;
            }
            else if(sum<target){
                left=left.next;
                len--;
            }
            else{
                right=right.prev;
                len--;
            }
        }
        return list;
    }

    //but this doesnt gives in the sorted order
//    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
//                                                                      Node head) {
//        // code here
//        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
//        HashSet<Integer> set = new HashSet<>();
//        Node temp=head;
//        while(temp!=null){
//            if(set.contains(target-temp.data)){
//                ArrayList<Integer> tempList=new ArrayList<>();
//                tempList.add(target-temp.data);
//                tempList.add(temp.data);
//                list.add(tempList);
//            }
//            set.add(temp.data);
//            temp=temp.next;
//        }
//        return list;
//    }
}
