package step15_graphs.lec3_topo_sort_and_problems;
import java.util.*;
public class p1_topological_sort {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        boolean[] visited= new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,st,adj,visited);
            }
        }


        while(!st.isEmpty()){
            ans.add(st.pop());
        }

        return ans;
    }

    public static void dfs(int node , Stack<Integer> st,List<List<Integer>> adj,boolean[] visited ){
        if(visited[node]){
            return;
        }
        visited[node]=true;
        for(int it:adj.get(node)){
            dfs(it,st,adj,visited);
        }
        st.push(node);

    }
}
