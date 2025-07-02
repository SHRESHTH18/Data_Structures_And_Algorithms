package step15_graphs.lec4_shortest_paths;
import java.util.*;
public class p2_shortest_paths_DAG {
    class Pair{
        int node;
        int dist;

        public Pair(int node,int dist){
            this.node= node;
            this.dist=dist;
        }
    }
    public void toposort(int node,List<List<Pair>> adj,boolean[] vis,Stack<Integer> st){
        vis[node]=true;
        for(int i=0;i<adj.get(node).size();i++){
            int v= adj.get(node).get(i).node;
            if(!vis[v]){
                toposort(v,adj,vis,st);
            }
        }
        st.push(node);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int dist=edges[i][2];
            adj.get(u).add(new Pair(v,dist));
        }

        boolean[] vis = new boolean[V];
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                toposort(i,adj,vis,st);
            }
        }

        int[] dist= new int[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[0]=0;
        while(!st.isEmpty()){
            int node= st.pop();
            for(int i=0;i<adj.get(node).size();i++){
                int v= adj.get(node).get(i).node;
                int d=adj.get(node).get(i).dist;
                if (dist[node] != Integer.MAX_VALUE) {
                    dist[v] = Math.min(dist[v], dist[node] + d);
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        return dist;
    }
}
