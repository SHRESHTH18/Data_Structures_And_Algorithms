package step7_Recursion.Lec3_hard;
import java.util.*;
public class p3_N_Queen {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        helper(0,board,ans);
        return ans;
    }
    public void helper(int col , char[][] board ,List<List<String>> ans ){
        if(col==board.length){
            ans.add(construct(board));
            return;
        }
        for(int i=0;i<board.length;i++){
            if(isSafe(i,col,board)){
                board[i][col]='Q';
                helper(col+1,board,ans);
                board[i][col]='.';
            }
        }
    }
    public List<String> construct(char[][] board){
        int n= board.length;
        List<String> list= new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(new String(board[i]));
        }
        return list;
    }
    public boolean isSafe(int row,int col ,char[][] board){
        // we only check for left side of the column
        int n =board.length;
        int i = row;
        int j = col;
        while(j>=0){
            if(board[row][j--]=='Q'){
                return false;
            }
        }
        i=row;
        j=col;
        while(i>=0 && j>=0){
            if(board[i--][j--]=='Q'){
                return false;
            }
        }
        i=row;
        j=col;
        while(i<n && j>=0){
            if(board[i++][j--]=='Q'){
                return false;
            }
        }
        return true;
    }
}
