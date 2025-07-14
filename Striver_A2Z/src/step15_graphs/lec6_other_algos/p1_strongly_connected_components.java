package step15_graphs.lec6_other_algos;
import java.util.*;
public class p1_strongly_connected_components {
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n =adj.size();
        boolean[] vis =new boolean[n];
        Stack<Integer> finish=new Stack<>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,adj,vis,finish);
            }
        }


        //reverse graph
        List<List<Integer>> rev= new ArrayList<>();
        for(int i=0;i<n;i++){
            rev.add(new ArrayList<>());
        }
        for(int i=0;i<adj.size();i++){
            for(int it:adj.get(i)){
                rev.get(it).add(i);
            }
        }
        int count=0;
        Arrays.fill(vis,false);
        while(!finish.isEmpty()){
            int el=finish.pop();
            if(!vis[el]){
                new_dfs(el,rev,vis);
                count++;
            }
        }
        return count;
    }

    public void new_dfs(int node,List<List<Integer>> adj , boolean[] vis){
        if(vis[node]) return;
        vis[node]=true;
        for(int it:adj.get(node)){
            new_dfs(it,adj,vis);
        }
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj , boolean[] vis, Stack<Integer> finish){
        if(vis[node]) return;
        vis[node]=true;
        for(int it:adj.get(node)){
            dfs(it,adj,vis,finish);
        }
        finish.push(node);
    }
}
