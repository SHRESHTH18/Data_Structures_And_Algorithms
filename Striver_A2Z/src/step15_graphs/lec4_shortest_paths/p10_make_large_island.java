package step15_graphs.lec4_shortest_paths;
import java.util.*;
public class p10_make_large_island {
    class DisjointSet{
        List<Integer> parent=new ArrayList<>();
        List<Integer> size= new ArrayList<>();
        public DisjointSet(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
            }
        }
        public int findParent(int n){
            if(n==parent.get(n)) return n;
            int par=findParent(parent.get(n));
            parent.set(n,par);
            return par;
        }
        public void union(int u,int v){
            int pu = findParent(u);
            int pv = findParent(v);
            if(pu==pv) return ;
            if(size.get(pu)<size.get(pv)){
                parent.set(pu,pv);
                size.set(pv,size.get(pu)+size.get(pv));
            }
            else{
                parent.set(pv,pu);
                size.set(pu,size.get(pu)+size.get(pv));
            }
        }
        public int getSize(int n){
            return size.get(findParent(n));
        }
    }
    class Solution {
        public int largestIsland(int[][] grid) {
            int n = grid.length;
            int m=grid[0].length;
            int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
            DisjointSet ds= new DisjointSet(m*n);
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==0) continue;
                    int node= i*m + j;//(row*m) + col
                    for(int[] dir:dirs){
                        int ni=i+dir[0];
                        int nj=j+dir[1];
                        if(ni==-1 || nj==-1 || ni==n || nj==m || grid[ni][nj]==0){
                            continue;
                        }
                        ds.union(node,ni*m+nj);
                    }
                }
            }

            int max=1;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){

                    if(grid[i][j]==1){
                        max=Math.max(max,ds.getSize(i*m +j));
                        continue;
                    }
                    int node=i*m+j;
                    int count=1;
                    HashSet<Integer> set = new HashSet<>();
                    for(int[] dir:dirs){
                        int ni=dir[0]+i;
                        int nj=dir[1]+j;
                        if(ni==-1 || nj==-1||ni==n||nj==m||grid[ni][nj]==0) continue;
                        set.add(ds.findParent(ni*m+nj));
                    }

                    for(int it:set){
                        count+=ds.getSize(it);
                    }
                    max=Math.max(max,count);
                }
            }
            return max;
        }

    }



// class DisjointSet {
//     List<Integer> parent = new ArrayList<>();
//     List<Integer> size = new ArrayList<>();

//     public DisjointSet(int n) {
//         for (int i = 0; i < n; i++) {
//             parent.add(i);
//             size.add(1);
//         }
//     }

//     public int findParent(int n) {
//         if (n == parent.get(n)) return n;
//         int par = findParent(parent.get(n));
//         parent.set(n, par);
//         return par;
//     }

//     public void union(int u, int v) {
//         int pu = findParent(u);
//         int pv = findParent(v);
//         if (pu == pv) return;

//         if (size.get(pu) < size.get(pv)) {
//             parent.set(pu, pv);
//             size.set(pv, size.get(pu) + size.get(pv));
//         } else {
//             parent.set(pv, pu);
//             size.set(pu, size.get(pu) + size.get(pv));
//         }
//     }

//     public int getSize(int n) {
//         return size.get(findParent(n));
//     }
// }

// class Solution {
//     public int largestIsland(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
//         DisjointSet ds = new DisjointSet(n * m);

//         // Union all 1's
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (grid[i][j] == 0) continue;
//                 int node = i * m + j;
//                 for (int[] dir : dirs) {
//                     int ni = i + dir[0];
//                     int nj = j + dir[1];
//                     if (ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] == 1) {
//                         int adjNode = ni * m + nj;
//                         ds.union(node, adjNode);
//                     }
//                 }
//             }
//         }

//         int max = 0;

//         // Try flipping each 0 and calculate resulting island size
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (grid[i][j] == 1) continue;

//                 HashSet<Integer> parents = new HashSet<>();
//                 int count = 1; // count this flipped 0

//                 for (int[] dir : dirs) {
//                     int ni = i + dir[0];
//                     int nj = j + dir[1];
//                     if (ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] == 1) {
//                         parents.add(ds.findParent(ni * m + nj));
//                     }
//                 }

//                 for (int par : parents) {
//                     count += ds.getSize(par);
//                 }

//                 max = Math.max(max, count);
//             }
//         }

//         // In case there are no 0s, check existing max
//         for (int i = 0; i < n * m; i++) {
//             max = Math.max(max, ds.getSize(i));
//         }

//         return max;
//     }
// }
}
