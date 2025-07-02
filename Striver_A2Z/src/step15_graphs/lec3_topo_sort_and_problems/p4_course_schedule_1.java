package step15_graphs.lec3_topo_sort_and_problems;
import java.util.*;
public class p4_course_schedule_1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u= prerequisites[i][0];
            int v= prerequisites[i][1];
            adj.get(v).add(u);
        }

        int[] indegree= new int[numCourses];
        for(int i=0;i<adj.size();i++){
            for(int el:adj.get(i)){
                indegree[el]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            count++;
            int el= q.poll();
            for(int it:adj.get(el)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }
        }
        return count==numCourses; // no cycle - true // if cycle - false
    }
}
