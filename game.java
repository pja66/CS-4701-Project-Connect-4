import gameInterface;

public class game implements gameInterface {
  public int[][] board = new int[6][7];
  public int turn = 1;
  public int yellow = 1;
  public int red = -1;
  public int id;

  public game(int boardId) {
    id = boardId;
  }

  public boolean gameOver() {
    return true;
  }

  public void changeTurn() {
    if (this.turn == -1)
      this.turn = 1;
    else
      this.turn = -1;
  }

  public boolean placeMove(int colMove) {
    for (int row = 5; row > -1; row--) {
      if (this.board[row][colMove] == 0) {
        this.board[row][colMove] = this.turn;
        changeTurn();
        return true;
      }
    }

    return false;
  }

  public void resetBoard() {

  }

  public void showBoard(int[][] board) {

  }
}