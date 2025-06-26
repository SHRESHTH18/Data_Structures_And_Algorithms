package step15_graphs.lec2_bfs_and_dfs;
import java.util.*;
public class p7_0_1_matrix {
    class Pair{
        int i;
        int j;
        int level;

        public Pair(int i,int j, int level){
            this.i = i;
            this.j=j;
            this.level= level;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int[][] dist = new int[mat.length][mat[0].length];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                dist[i][j]=mat[i][j];
            }
        }

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(dist[i][j]==1){
                    dist[i][j]=bfs(i,j,mat);
                }
            }
        }
        return dist;
    }

    public int bfs(int x,int y , int[][] mat ){
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(x,y,0));
        int min=Integer.MAX_VALUE;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            Pair current = q.poll();
            int i=current.i;
            int j=current.j;
            for(int[] dir: directions){
                int ni=i+dir[0];
                int nj=j+dir[1];
                if(ni>=0 && nj>=0 && ni<mat.length && nj<mat[0].length){
                    if(mat[ni][nj]==1){
                        q.offer(new Pair(ni,nj,current.level+1));
                    }
                    else{
                        return current.level+1;
                    }
                }
            }
        }
        return -1;
    }
}
