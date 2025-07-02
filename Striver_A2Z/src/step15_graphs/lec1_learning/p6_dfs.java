package step15_graphs.lec1_learning;
import java.util.*;
public class p6_dfs {

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<adj.size();i++){
            if(!visited[i]){
                dfs(i,adj,visited,ans);
            }
        }

        return ans;
    }
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj ,boolean[] visited , ArrayList<Integer> ans){
        ans.add(node);
        visited[node]=true;
        for(Integer it: adj.get(node)){
            if(!visited[it]){
                dfs(it,adj,visited,ans);
            }
        }
    }
}
