package step15_graphs.lec6_other_algos;
import java.util.*;
public class p2_bridges_in_graph {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<connections.size();i++){
            int u=connections.get(i).get(0);
            int v=connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<List<Integer>> ans= new ArrayList<>();

        int[] parent=new int[n];
        int[] start=new int[n];
        int[] finish = new int[n];
        boolean[] vis=new boolean[n];
        dfs(0,adj,parent,start,finish,vis,ans);
        return ans;

    }
    public void dfs(int node,List<List<Integer>> adj,int[] parent,int[] start,int[] finish,boolean[] vis,List<List<Integer>> ans){
        if(vis[node]) return;
        vis[node]=true;
        for(int it:adj.get(node)){
            if(vis[it]) continue;
            parent[it]=node;
            start[it]=start[node]+1;
            finish[it]=start[it];
            dfs(it,adj,parent,start,finish,vis,ans);
        }

        for(int it:adj.get(node)){
            if(it==parent[node]) continue;
            finish[node]=Math.min(finish[node],finish[it]);
        }

        if(finish[node]>start[parent[node]]){
            List<Integer> list= new ArrayList<>();
            list.add(node);
            list.add(parent[node]);
            ans.add(list);
        }
    }


//    class Solution {
//        int time = 0;
//
//        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
//            List<List<Integer>> adj = new ArrayList<>();
//            for(int i = 0; i < n; i++) {
//                adj.add(new ArrayList<>());
//            }
//
//            for(List<Integer> conn : connections) {
//                int u = conn.get(0);
//                int v = conn.get(1);
//                adj.get(u).add(v);
//                adj.get(v).add(u);
//            }
//
//            int[] disc = new int[n];
//            int[] low = new int[n];
//            boolean[] vis = new boolean[n];
//            List<List<Integer>> ans = new ArrayList<>();
//
//            dfs(0, -1, adj, vis, disc, low, ans);
//            return ans;
//        }
//
//        private void dfs(int u, int parent, List<List<Integer>> adj, boolean[] vis, int[] disc, int[] low, List<List<Integer>> ans) {
//            vis[u] = true;
//            disc[u] = low[u] = time++;
//
//            for(int v : adj.get(u)) {
//                if(v == parent) continue;
//
//                if(!vis[v]) {
//                    dfs(v, u, adj, vis, disc, low, ans);
//                    low[u] = Math.min(low[u], low[v]);
//
//                    if(low[v] > disc[u]) {
//                        ans.add(Arrays.asList(u, v));  // Critical connection
//                    }
//                } else {
//                    low[u] = Math.min(low[u], disc[v]); // Back edge
//                }
//            }
//        }
//    }
}

