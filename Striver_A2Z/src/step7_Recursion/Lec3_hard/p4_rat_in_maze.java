package step7_Recursion.Lec3_hard;
import java.util.*;
public class p4_rat_in_maze {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> ans= new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(0,0,maze,ans,sb);
        return ans;
    }
    public void helper(int row,int col,int[][] maze, List<String> ans,StringBuilder sb){
        int n=maze.length;
        if( row >= n ||col >= n ||row<0 ||col<0 ||maze[row][col]==0){
            return;
        }
        if(row==n-1 && col == n-1){
            ans.add(sb.toString());
            return;
        }
        maze[row][col]=0;
        sb.append('D');
        helper(row+1,col,maze,ans,sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append('L');
        helper(row,col-1,maze,ans,sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append('R');
        helper(row,col+1,maze,ans,sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append('U');
        helper(row-1,col,maze,ans,sb);
        sb.deleteCharAt(sb.length()-1);
        maze[row][col]=1;
    }
}
