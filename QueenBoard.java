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
    board[r][c] += 1;
    for (int i = 1; r + i < board.length; i ++){
      board[r + i][c] -= 1;
    }
    for (int i = 1; r + i < board.length && c + i < board.length; i ++){
      board[r + i][c + i] -= 1;
    }
    return true;
  }
  public String toString(){
    String newstr = "";
    for (int i = 0; i < board.length; i ++){
      for (int x = 0; x < board[i].length; x++){
        if (board[i][x] == 1){
          newstr += "Q";
        }
        else{
          newstr += "_";
        }
      }
      newstr += "\n";
    }
    return newstr;
  }
}
