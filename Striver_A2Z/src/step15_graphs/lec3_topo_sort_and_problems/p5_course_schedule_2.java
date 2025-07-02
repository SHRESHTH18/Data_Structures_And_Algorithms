package step15_graphs.lec3_topo_sort_and_problems;
import java.util.*;
public class p5_course_schedule_2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][1];
            int v= prerequisites[i][0];
            adj.get(u).add(v);
        }

        int[] indegree= new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int index=0;
        while(!q.isEmpty()){
            int el=q.poll();
            result[index++]=el;
            for(int i:adj.get(el)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        if(numCourses>1 && result[numCourses-1]==0 && result[numCourses-2]==0){
            return new int[0];
        }
        return result;
    }
}
