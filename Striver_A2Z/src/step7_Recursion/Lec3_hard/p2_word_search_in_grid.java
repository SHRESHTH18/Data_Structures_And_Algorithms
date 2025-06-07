package step7_Recursion.Lec3_hard;
import java.util.*;
public class p2_word_search_in_grid {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        List<List<Integer>> first= new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word.charAt(0)==board[i][j]){
                    if (helper(i, j, 0, board, word, m, n)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
    public boolean helper(int row , int col ,int index, char[][] board , String word ,int m,int n){
        if (index == word.length())
            return true;
        if(row<0 || col<0 ||row==m || col == n || board[row][col]!=word.charAt(index) || board[row][col]=='!'){
            return false;
        }
        char c= board[row][col];
        board[row][col] = '!';

        boolean right=helper(row,col+1,index+1,board,word,m,n);
        boolean left=helper(row,col-1,index+1,board,word,m,n);
        boolean top = helper(row-1,col,index+1,board,word,m,n);
        boolean bottom= helper(row+1,col,index+1,board,word,m,n);

        board[row][col] = c;
        return top||bottom||left||right ;
    }
}
