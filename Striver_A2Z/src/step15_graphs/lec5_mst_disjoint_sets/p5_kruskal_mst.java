package step15_graphs.lec5_mst_disjoint_sets;
import java.util.*;
public class p5_kruskal_mst {
    // User function Template for Java
    class DisjointSet{
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent= new ArrayList<>();
        public DisjointSet(int n){
            for(int i=0;i<n;i++){
                rank.add(0);
                parent.add(i);
            }
        }

        public int findParent(int n){
            if(parent.get(n)==n) return n;
            int par=findParent(parent.get(n));
            parent.set(n,par);
            return parent.get(n);
        }

        public void union(int u,int v){
            int ulp_u=findParent(u);
            int ulp_v=findParent(v);
            if(ulp_u==ulp_v) return;
            if(rank.get(ulp_u)<rank.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
            }
            else if(rank.get(ulp_u)>rank.get(ulp_v)){
                parent.set(ulp_v,ulp_u);
            }
            else{
                parent.set(ulp_v,ulp_u);
                rank.set(ulp_u,rank.get(ulp_u)+1);
            }
        }
    }
    int kruskalsMST(int V, int[][] edges) {
        // code here
        List<int[]> edgeList = new ArrayList<>();
        for(int[] i:edges){
            int[] edge=new int[3];
            edge[1]=i[0];//u
            edge[2]=i[1];//v
            edge[0]=i[2];//wt
            edgeList.add(edge);
        }

        Collections.sort(edgeList,(a,b)->a[0]-b[0]);
        DisjointSet ds= new DisjointSet(V);
        int mst_wt=0;
        for(int i=0;i<edgeList.size();i++){
            int[] it = edgeList.get(i);
            if(ds.findParent(it[1])!=ds.findParent(it[2])){
                mst_wt+=it[0];
                ds.union(it[1],it[2]);
            }
        }
        return mst_wt;
    }
}
