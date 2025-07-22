package step13_binary_trees.lec3_hard_problems;
import java.util.*;
public class p1_root_to_node_path {


    private boolean getPath(TreeNode root, ArrayList<Integer> arr, int x) {
        if (root == null)
            return false;

        arr.add(root.val);

        if (root.val == x)
            return true;

        if (getPath(root.left, arr, x) || getPath(root.right, arr, x))
            return true;

        arr.remove(arr.size() - 1); // backtrack
        return false;
    }

    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> arr = new ArrayList<>();
        getPath(A, arr, B); // ignore return, result is stored in arr
        return arr;
    }
}
