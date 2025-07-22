package step13_binary_trees.lec2_medium_problems;
import java.util.*;
public class p8_vertical_traversal {
    class Tuple {
        TreeNode node;
        int row, col;

        public Tuple(TreeNode _node, int _row, int _col) {
            node = _node;
            row = _row;
            col = _col;
        }
    }

    class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
            Queue<Tuple> q = new LinkedList<>();
            q.offer(new Tuple(root, 0, 0));

            while (!q.isEmpty()) {
                Tuple tuple = q.poll();
                TreeNode node = tuple.node;
                int x = tuple.row;
                int y = tuple.col;

                map.putIfAbsent(x, new TreeMap<>());
                map.get(x).putIfAbsent(y, new PriorityQueue<>());
                map.get(x).get(y).offer(node.val);

                if (node.left != null) {
                    q.offer(new Tuple(node.left, x - 1, y + 1));
                }
                if (node.right != null) {
                    q.offer(new Tuple(node.right, x + 1, y + 1));
                }
            }

            List<List<Integer>> list = new ArrayList<>();
            for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
                List<Integer> colList = new ArrayList<>();
                for (PriorityQueue<Integer> nodes : ys.values()) {
                    while (!nodes.isEmpty()) {
                        colList.add(nodes.poll());
                    }
                }
                list.add(colList);
            }

            return list;
        }
    }
}
