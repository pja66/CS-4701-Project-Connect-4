public class Game implements GameInterface {
  public int[][] board = new int[6][7];
  public int yellow = 1;
  public int red = 2;
  public int turn = yellow; // Yellow Goes first
  public int id;

  // Constructor
  public Game(int boardId) {
    id = boardId;
  }

  public boolean fourInARow(int turn, int row, int col) {
    // Vertical
    if (row + 3 < this.board.length) {
      boolean t1 = this.board[row][col] == turn;
      boolean t2 = this.board[row + 1][col] == turn;
      boolean t3 = this.board[row + 2][col] == turn;
      boolean t4 = this.board[row + 3][col] == turn;

      if (t1 && t2 && t3 && t4)
        return true;
    }

    // Horizontal
    if (col + 3 < this.board[0].length) {
      boolean t1 = this.board[row][col] == turn;
      boolean t2 = this.board[row][col + 1] == turn;
      boolean t3 = this.board[row][col + 2] == turn;
      boolean t4 = this.board[row][col + 3] == turn;

      if (t1 && t2 && t3 && t4)
        return true;
    }

    // Diagonal
    if (col + 3 < this.board[0].length && row + 3 < this.board.length) {
      boolean t1 = this.board[row][col] == turn;
      boolean t2 = this.board[row + 1][col + 1] == turn;
      boolean t3 = this.board[row + 2][col + 2] == turn;
      boolean t4 = this.board[row + 3][col + 3] == turn;

      if (t1 && t2 && t3 && t4)
        return true;
    }
    return false;
  }

  public boolean boardfull() {
    int rows = this.board.length;
    int cols = this.board[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (this.board[i][j] == 0)
          return false;
      }
    }
    return true;
  }

  public int gameOver() {
    int rows = this.board.length;
    int cols = this.board[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (this.board[i][j] != 0) {
          if (fourInARow(this.turn, i, j))
            return 2;
        }
      }
    }
    return boardfull() ? 1 : 0;
  }

  public void changeTurn() {
    if (this.turn == this.yellow)
      this.turn = this.red;
    else
      this.turn = this.yellow;
  }

  public boolean placeMove(int colMove) {
    for (int row = 0; row < 6; row++) {
      if (this.board[row][colMove] == 0) {
        this.board[row][colMove] = this.turn;
        changeTurn();
        return true;
      }
    }
    return false;
  }

  public void resetBoard() {
    this.board = new int[6][7];
  }

  public void showBoard() {
    int rows = this.board.length;
    int cols = this.board[0].length;

    for (int i = rows - 1; i > -1; i--) {
      System.out.print(" | ");
      for (int j = 0; j < cols; j++) {
        System.out.print(this.board[i][j]);
        System.out.print(" | ");
      }
      System.out.println();
    }
  }
}