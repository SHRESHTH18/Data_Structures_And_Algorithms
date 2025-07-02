package step15_graphs.lec5_mst_disjoint_sets;
import java.util.*;
public class p6_num_operations_to_get_network_connected {

    static class DSU {
        int[] parent, rank;
        int components;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int u) {
            if (parent[u] != u)
                parent[u] = find(parent[u]); // Path compression
            return parent[u];
        }

        boolean union(int u, int v) {
            int pu = find(u), pv = find(v);
            if (pu == pv) return false; // Redundant edge
            if (rank[pu] < rank[pv]) {
                parent[pu] = pv;
            } else if (rank[pu] > rank[pv]) {
                parent[pv] = pu;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }
            components--;
            return true;
        }

        int getComponentCount() {
            return components;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1; // Not enough cables

        DSU dsu = new DSU(n);
        for (int[] conn : connections) {
            dsu.union(conn[0], conn[1]);
        }

        int components = dsu.getComponentCount();
        return components - 1; // Need (components - 1) cables to connect
    }

//    public void dfs(int node,boolean[] vis,List<List<Integer>> adj){
//        vis[node]=true;
//        for(int it:adj.get(node)){
//            if(!vis[it])
//                dfs(it,vis,adj);
//        }
//    }
//    public int makeConnected(int n, int[][] connections) {
//        if(connections.length<n-1) return -1;
//
//        List<List<Integer>> adj=new ArrayList<>();
//        for(int i=0;i<n;i++){
//            adj.add(new ArrayList<>());
//        }
//        for(int i=0;i<connections.length;i++){
//            int u= connections[i][0];
//            int v= connections[i][1];
//            adj.get(u).add(v);
//            adj.get(v).add(u);
//        }
//        boolean[] vis= new boolean[n];
//
//        int count=0;
//        for(int i=0;i<n;i++){
//            if(!vis[i]){
//                dfs(i,vis,adj);
//                count++;
//            }
//        }
//
//        return count-1;
//    }
}
