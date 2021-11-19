public class Game implements GameInterface {
  public int[][] board = new int[6][7];
  public int yellow = 1;
  public int red = -1;
  public int turn = yellow; // Yellow Goes first 
  public int id;

  // Constructors
  public Game(int boardId) {
    id = boardId;
  }

  public Game(Game copy) {
    this.turn = copy.turn;

    for(int i = 0; i < 6; i++)
    {
      for(int j = 0; j< 7; j++)
        this.board[i][j] =  copy.board[i][j];
    }
  }

  public int otherPlayer()
  {
    if(this.turn == this.yellow)
      return this.red;
    else
      return this.yellow;
  }

  private boolean fourInARow(int turn, int row, int col) {
    // Vertical
    if (row + 3 < 6) {
      boolean t1 = this.board[row][col] == turn;
      boolean t2 = this.board[row + 1][col] == turn;
      boolean t3 = this.board[row + 2][col] == turn;
      boolean t4 = this.board[row + 3][col] == turn;

      if (t1 && t2 && t3 && t4)
        return true;
    }

    // Horizontal
    if (col + 3 < 7) {
      boolean t1 = this.board[row][col] == turn;
      boolean t2 = this.board[row][col + 1] == turn;
      boolean t3 = this.board[row][col + 2] == turn;
      boolean t4 = this.board[row][col + 3] == turn;

      if (t1 && t2 && t3 && t4)
        return true;
    }

    // Diagonal Positive Slope
    if (col + 3 < 7 && row + 3 < 6) {
      boolean t1 = this.board[row][col] == turn;
      boolean t2 = this.board[row + 1][col + 1] == turn;
      boolean t3 = this.board[row + 2][col + 2] == turn;
      boolean t4 = this.board[row + 3][col + 3] == turn;

      if (t1 && t2 && t3 && t4)
        return true;
    }

    // Diagonal Negitive Slope
    if (col - 3 > -1 && row + 3 < 6) {
      boolean t1 = this.board[row][col] == turn;
      boolean t2 = this.board[row + 1][col - 1] == turn;
      boolean t3 = this.board[row + 2][col - 2] == turn;
      boolean t4 = this.board[row + 3][col - 3] == turn;

      if (t1 && t2 && t3 && t4)
        return true;
    }

    return false;
  }

  private boolean boardfull() {
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 7; j++) {
        if (this.board[i][j] == 0)
          return false;
      }
    }
    return true;
  }

  public int gameOver() {
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 7; j++) {
        if (this.board[i][j] != 0) {
          if (fourInARow(this.yellow, i, j))
            return 2;

          if (fourInARow(this.red, i, j))
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

  public int placeMove(int colMove) {
    if(colMove < 0 || colMove > 6)
      return -1;

    for (int row = 0; row < 6; row++) {
      if (this.board[row][colMove] == 0) {
        this.board[row][colMove] = this.turn;
        changeTurn();
        return row;
      }
    }
    return -1;
  }

  public int removeMove(int colMove) {
    for (int row = 5; row > -1; row--) {
      if (this.board[row][colMove] != 0 && this.board[row][colMove] != this.turn) 
      {
        this.board[row][colMove] = 0;
        changeTurn();
        return row;
      }

    }
    return -1;
  }

  public void resetBoard() {
    this.board = new int[6][7];
  }

  public void showBoard() {
    for (int i = 6 - 1; i > -1; i--) {
      System.out.print(" | ");
      for (int j = 0; j < 7; j++) {
        if(this.board[i][j] == this.yellow)
          System.out.print("\uD83D\uDFE1");
        else if(this.board[i][j] == this.red)
          System.out.print("\uD83D\uDD34");
        else 
          System.out.print("  ");

        System.out.print(" | ");
      }
      System.out.println();
    }

    System.out.print("  ");
    for(int i = 0; i < 7; i++)
    {
      System.out.print("  " + i + "  ");
    }
    System.out.println();
  }
}