package step15_graphs.lec4_shortest_paths;

public class p13_city_with_least_neighbours_within_threshold_distance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=(int)1e9;
                if(i==j) dist[i][j]=0;
            }
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int d= edges[i][2];
            dist[u][v]=d;
            dist[v][u]=d;
        }

        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][via]==(int)1e9 || dist[via][j]==(int)1e9){
                        continue;
                    }
                    dist[i][j]=Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                }
            }
        }
        int min=Integer.MAX_VALUE;
        int min_node=0;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=min){
                min=count;
                min_node=i;
            }

        }
        return min_node;
    }
}
