package step15_graphs.lec5_mst_disjoint_sets;
import java.util.*;
public class p8_accounts_merge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String str=accounts.get(i).get(j);
                if(map.keySet().contains(str)){
                    ds.union(i,map.get(str));
                    continue;
                }
                map.put(str,i);
            }
        }
        List<List<String>> merged= new ArrayList<>();
        for(int i=0;i<n;i++){
            merged.add(new ArrayList<>());
        }
        for(String it:map.keySet()){
            int par=ds.findParent(map.get(it));
            merged.get(par).add(it);
        }
        List<List<String>> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            int len=merged.get(i).size();
            if(len==0) continue;
            List<String> acc=new ArrayList<>();

            for(int j=0;j<len;j++){
                acc.add(merged.get(i).get(j));
            }
            Collections.sort(acc);
            acc.add(0,accounts.get(i).get(0));
            result.add(acc);
        }
        return result;
    }
}
class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
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
        int pv=findParent(v);
        if(pu==pv) return;
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

