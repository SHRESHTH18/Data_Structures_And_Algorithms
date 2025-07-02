package step15_graphs.lec5_mst_disjoint_sets;
import java.util.*;
class Pair{
    int elv;
    int i;
    int j;
    public Pair(int elv,int i,int j){
        this.elv=elv;
        this.i=i;
        this.j=j;
    }
}
public class p11_swim_in_rising_water {
    public int swimInWater(int[][] grid) {
        int max=0;
        int n=grid.length;
        int m= grid[0].length;
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.elv-b.elv);
        boolean[][] vis=new boolean[n][m];
        vis[0][0]=true;
        pq.offer(new Pair(grid[0][0],0,0));
        while(!pq.isEmpty()){
            Pair el = pq.poll();
            int i=el.i;
            int j=el.j;
            int wt=el.elv;
            max=Math.max(max,wt);
            if(i==n-1 && j==n-1){
                return max;
            }
            int[][] dirs= {{0,1},{0,-1},{1,0},{-1,0}};
            for(int[] dir:dirs){
                int ni=i+dir[0];
                int nj=j+dir[1];

                if(ni==-1 || nj==-1 || ni==n || nj==m || vis[ni][nj]) continue;
                pq.offer(new Pair(grid[ni][nj],ni,nj));
                vis[ni][nj]=true;
            }
        }

        return max;//never reach here
    }

}


