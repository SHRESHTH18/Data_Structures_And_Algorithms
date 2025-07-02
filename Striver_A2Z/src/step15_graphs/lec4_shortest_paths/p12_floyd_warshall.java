package step15_graphs.lec4_shortest_paths;

public class p12_floyd_warshall {
    public void floydWarshall(int[][] dist) {
        // Code here
        int v= dist.length;
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                for(int k=0;k<v;k++){
                    if(dist[j][i]==(int)1e8 || dist[i][k]==(int)1e8){
                        continue;
                    }
                    dist[j][k]=Math.min(dist[j][k] , dist[j][i]+dist[i][k]);
                }
            }
        }
    }
}
