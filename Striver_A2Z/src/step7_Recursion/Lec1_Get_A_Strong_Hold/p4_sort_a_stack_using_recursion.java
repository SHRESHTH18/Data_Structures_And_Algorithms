package step7_Recursion.Lec1_Get_A_Strong_Hold;
import java.util.Scanner;
import java.util.Stack;
public class p4_sort_a_stack_using_recursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner in = new Scanner(System.in);
        System.out.println("enter n");
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            stack.push(in.nextInt());
        }

    }
    public static void sortedInsert(Stack<Integer> s, int x) {
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }
        int temp = s.pop();
        sortedInsert(s, x);
        s.push(temp);
    }

    public static void sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            sort(s);
            sortedInsert(s, x);
        }
    }
}
