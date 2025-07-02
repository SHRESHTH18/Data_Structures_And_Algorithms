package step15_graphs.lec5_mst_disjoint_sets;
import java.util.*;

public class p7_max_stone_removal {
    class DisjointSet{
        ArrayList<Integer> rank= new ArrayList<>();
        ArrayList<Integer> parent=new ArrayList<>();
        public DisjointSet(int n){
            for(int i=0;i<n;i++){
                rank.add(0);
                parent.add(i);
            }
        }
        public int findParent(int n){
            if(n==parent.get(n)) return n;
            int par=findParent(parent.get(n));
            parent.set(n,par);
            return par;
        }

        public void union(int u,int v){
            int pu=findParent(u);
            int pv= findParent(v);
            if(pu==pv)return;
            if(rank.get(pu)<rank.get(pv)){
                parent.set(pu,pv);
            }
            else if(rank.get(pu)>rank.get(pv)){
                parent.set(pv,pu);
            }
            else{
                parent.set(pv,pu);
                rank.set(pu,rank.get(pu)+1);
            }
        }
    }
    class Solution {
        public int removeStones(int[][] stones) {
            int maxRow=0;
            int maxCol=0;
            int n= stones.length;
            for(int i=0;i<n;i++){
                maxRow=Math.max(maxRow,stones[i][0]);
                maxCol=Math.max(maxCol,stones[i][1]);
            }
            int nodes=maxRow+maxCol+2;
            DisjointSet ds= new DisjointSet(nodes);
            for(int i=0;i<n;i++){
                int row= stones[i][0];
                int col=stones[i][1]+maxRow+1;
                ds.union(row,col);
            }

            Set<Integer> ult_parent=new HashSet();
            for(int i=0;i<nodes;i++){
                if(ds.findParent(i)==i) continue;
                ult_parent.add(ds.findParent(i));
            }
            return n-ult_parent.size();
        }
    }
}
