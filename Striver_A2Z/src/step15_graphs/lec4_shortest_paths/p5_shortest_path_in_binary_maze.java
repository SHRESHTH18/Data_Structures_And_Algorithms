package step15_graphs.lec4_shortest_paths;
import java.util.*;
public class p5_shortest_path_in_binary_maze {

    //only push in queue if distance reduces
    class Pair{
        int i;
        int j;
        int dist;

        public Pair(int i,int j, int dist){
            this.i=i;
            this.j=j;
            this.dist=dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n= grid.length;
        if(grid[0][0]==1||grid[n-1][n-1]==1){
            return -1;
        }
        if(grid.length==1) return 1;

        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=(int)1e9;
            }
        }
        dist[0][0]=1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,1));
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        while(!q.isEmpty()){
            Pair el = q.poll();
            int i=el.i;
            int j=el.j;
            int d=el.dist;
            for(int[] dir:dirs){
                int ni=i+dir[0];
                int nj=j+dir[1];
                if(ni==n-1 && nj==n-1){
                    return d+1;
                }
                if(ni==-1||ni==n||nj==-1||nj==n||grid[ni][nj]==1){
                    continue;
                }
                if(dist[i][j]+1<dist[ni][nj]){
                    q.offer(new Pair(ni,nj,d+1));
                    dist[ni][nj]=dist[i][j]+1;
                }

            }
        }
        return -1;
    }
    //TLE
//    class Pair{
//        int i;
//        int j;
//        int dist;
//
//        public Pair(int i,int j, int dist){
//            this.i=i;
//            this.j=j;
//            this.dist=dist;
//        }
//    }
//    public int shortestPathBinaryMatrix(int[][] grid) {
//        int n= grid.length;
//        if(grid[0][0]==1||grid[n-1][n-1]==1){
//            return -1;
//        }
//        if(grid.length==1) return 1;
//
//        int[][] dist = new int[n][n];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                dist[i][j]=(int)1e9;
//            }
//        }
//
//        Queue<Pair> q = new LinkedList<>();
//        q.offer(new Pair(0,0,1));
//        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
//        while(!q.isEmpty()){
//            Pair el = q.poll();
//            int i=el.i;
//            int j=el.j;
//            int d=el.dist;
//            for(int[] dir:dirs){
//                int ni=i+dir[0];
//                int nj=j+dir[1];
//                if(ni==n-1 && nj==n-1){
//                    return d+1;
//                }
//                if(ni==-1||ni==n||nj==-1||nj==n||grid[ni][nj]==1){
//                    continue;
//                }
//                q.offer(new Pair(ni,nj,d+1));
//            }
//        }
//        return -1;
//    }
}
