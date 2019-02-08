public class QueenBoard{
  private int[][] board;
  public QueenBoard(int size){
    board = new int[size][size];
  }
  private boolean addQueen(int r, int c){
    board[r][c] += 1;
    for (int i = 1; r + i < board.length){
      board[r + i][c] -= 1;
    }
    for (int i = 1; r + i < board.length && c + i < board.length){
      board[r + i][c + i] -= 1;
    }
    return true;
  }
}
