package step15_graphs.lec2_bfs_and_dfs;
import java.util.*;
public class p4_flood_fill {
    class Pair{
        int i;
        int j;

        public Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int start = image[sr][sc];
        if(start==color) return image;
        Queue<Pair> q = new ArrayDeque<>();
        image[sr][sc]=color;
        q.offer(new Pair(sr,sc));
        while(!q.isEmpty()){
            Pair el=q.poll();
            int i= el.i;
            int j=el.j;
            if(i>0 && image[i-1][j]==start){
                image[i-1][j]=color;
                q.offer(new Pair(i-1,j));
            }
            if(i<image.length-1 && image[i+1][j]==start){
                image[i+1][j]=color;
                q.offer(new Pair(i+1,j));
            }
            if(j>0 && image[i][j-1]==start){
                image[i][j-1]=color;
                q.offer(new Pair(i,j-1));
            }
            if(j<image[i].length-1 && image[i][j+1]==start){
                image[i][j+1]=color;
                q.offer(new Pair(i,j+1));
            }
        }
        return image;
    }
}
