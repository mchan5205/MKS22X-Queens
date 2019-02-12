public class QueenBoard{
  private int[][] board;
  public QueenBoard(int size){
    board = new int[size][size];
    for (int i = 0; i < board.length; i++){
      for (int x = 0; x < board[i].length; x ++){
        board[i][x] = 0;
      }
    }
  }
  private boolean addQueen(int r, int c){
    if (board[r][c] < 0){
      return false;
    }
    board[r][c] += 4;
    for (int i = 0; r + i < board.length; i ++){
      board[r + i][c] -= 1;
    }
    for (int i = 0; r + i < board.length && c + i < board.length; i ++){
      board[r + i][c + i] -= 1;
    }
    for (int i = 0; r + i < board.length && c - i >= 0; i ++){
      board[r + i][c - i] -= 1;
    }
    return true;
  }
  private boolean removeQueen(int r, int c){
    if (board[r][c] != 1){
      return false;
    }
    board[r][c] -= 4;
    for (int i = 0; r + i < board.length; i ++){
      board[r + i][c] += 1;
    }
    for (int i = 0; r + i < board.length && c + i < board.length; i ++){
      board[r + i][c + i] += 1;
    }
    for (int i = 0; r + i < board.length && c - i >= 0; i ++){
      board[r + i][c - i] += 1;
    }
    return true;
  }
  public String toString(){
    String newstr = "";
    for (int i = 0; i < board.length; i ++){
      for (int x = 0; x < board[i].length; x++){
        if (board[i][x] == 1){
          newstr += "Q ";
        }
        if (board[i][x] <= 0){
          newstr += "_ ";
        }
      }
      newstr += "\n";
    }
    return newstr;
  }
  public boolean solve(){
    return solveR(0);
  }
  public boolean solveR(int row){
    if (row == board.length){
      return true;
    }
    for (int i = 0; i < board.length; i ++){
      if (board[row][i] == 0){
        if (addQueen(row, i)){
          if (solveR(row + 1)){
            return true;
          }
          removeQueen(row, i);
        }
      }
    }
    return false;
  }
  public int countSolutions(){
    return countSolutionsh(0);
  }
  public int countSolutionsh(int row){
    int count = 0;
    if (row == board.length - 1){
      for (int x = 0 ; x < board.length; x ++){
        if (addQueen(row, x)){
          removeQueen(row, x);
          count += 1;
        }
      }
    }
    else{
      for (int i = 0; i < board.length; i ++){
        if (addQueen(row, i)){
          count += countSolutionsh(row + 1);
          removeQueen(row, i);
        }
      }
    }
    return count;
  }
}
