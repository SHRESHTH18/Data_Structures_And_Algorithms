package step7_Recursion.Lec3_hard;

public class p7_sudoku_solver {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    public boolean helper(char[][] board){
        int n= board.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(isValid(board,i,j,k)){
                            board[i][j]=k;
                            if(helper(board)) return true;//if solved, stop
                            board[i][j]='.';
                        }
                    }
                    return false;//no valid digit found
                }
            }
        }
        return true;//all digitis placed successfully
    }
    public boolean isValid(char[][] board , int row , int col,int ch){
        for(int i=0;i<9;i++){
            if(board[row][i]==ch){ // same row
                return false;
            }
            if(board[i][col]==ch){ // same col
                return false;
            }
            if(board[3*(row/3)+i/3][3*(col/3) + i%3]==ch){ // same box
                return false;
            }
        }
        return true;
    }
}
