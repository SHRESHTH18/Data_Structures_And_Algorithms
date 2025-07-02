package step15_graphs.lec3_topo_sort_and_problems;
import java.util.*;
public class p6_find_eventual_safe_states {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                adj.get(node).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        // Push all the nodes with indegree zero in the queue.
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        boolean[] safe = new boolean[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for (int neighbor : adj.get(node)) {
                // Delete the edge "node -> neighbor".
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

//    public List<Integer> eventualSafeNodes(int[][] graph) {
//        int v = graph.length;
//        List<Integer> result = new ArrayList<>();
//
//        int[] outdegree=new int[v];
//        Queue<Integer> q = new LinkedList<>();
//        for(int i=0;i<v;i++){
//            outdegree[i]=graph[i].length;
//            if(outdegree[i]==0){
//                q.offer(i);
//            }
//        }
//
//        while(!q.isEmpty()){
//            int el=q.poll();
//            result.add(el);
//            for(int i=0;i<v;i++){
//                for(int it:graph[i]){
//                    if(it==el){
//                        outdegree[i]--;
//                        if(outdegree[i]==0){
//                            q.offer(i);
//                        }
//                        break;
//                    }
//                }
//            }
//        }
//
//
//
//        Collections.sort(result);
//        return result;
//    }
}
