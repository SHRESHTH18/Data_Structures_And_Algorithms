package step15_graphs.lec2_bfs_and_dfs;
import java.util.*;

public class p3_rotten_oranges {
    class Pair{
        int i;
        int j;
        int minute;

        public Pair(int i,int j, int minute){
            this.i=i;
            this.j=j;
            this.minute=minute;
        }
    }
    public int orangesRotting(int[][] grid) {
        int one=0;
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    one++;
                }
                else if(grid[i][j]==2){
                    Pair rotten = new Pair(i,j,0);
                    q.offer(rotten);
                }
            }
        }

        int max=0;

        while(!q.isEmpty()){
            Pair rotten = q.poll();
            int i=rotten.i;
            int j=rotten.j;
            int minutes = rotten.minute;
            max=Math.max(max,minutes);
            if(i>0 && grid[i-1][j]==1){
                q.offer(new Pair(i-1,j,minutes+1));
                one--;
                grid[i-1][j]=2;
            }
            if(i<grid.length-1 && grid[i+1][j]==1){
                q.offer(new Pair(i+1,j,minutes+1));
                one--;
                grid[i+1][j]=2;
            }
            if(j>0 && grid[i][j-1]==1){
                q.offer(new Pair(i,j-1,minutes+1));
                one--;
                grid[i][j-1]=2;
            }
            if(j<grid[i].length-1  && grid[i][j+1]==1){
                q.offer(new Pair(i,j+1,minutes+1));
                one--;
                grid[i][j+1]=2;
            }
        }

        return one>0?-1:max;
    }
}
