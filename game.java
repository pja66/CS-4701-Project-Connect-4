public class Game implements GameInterface {
  public int[][] board = new int[6][7];
  public int turn = 1;
  public int yellow = 1;
  public int red = -1;
  public int id;

  public Game(int boardId) {
    id = boardId;
  }

  public boolean fourInARow(int turn, int row, int col,int[][] board){
    //Vertical
    if(row + 3 < board.length)
    {
      boolean t1 = board[row][col] == turn;
      boolean t2 = board[row+1][col] == turn;
      boolean t3 = board[row+2][col] == turn;
      boolean t4 = board[row+3][col] == turn;

      if(t1 && t2 && t3 && t4)
        return true;
    }

    //Horizontal
    if(col + 3 < board[0].length)
    {
      boolean t1 = board[row][col] == turn;
      boolean t2 = board[row][col+1] == turn;
      boolean t3 = board[row][col+2] == turn;
      boolean t4 = board[row][col+3] == turn;

      if(t1 && t2 && t3 && t4)
        return true;
    }

    //Diagonal
    if(col + 3 < board[0].length && row + 3 < board.length)
    {
      boolean t1 = board[row][col] == turn;
      boolean t2 = board[row+1][col+1] == turn;
      boolean t3 = board[row+2][col+2] == turn;
      boolean t4 = board[row+3][col+3] == turn;

      if(t1 && t2 && t3 && t4)
        return true;
    }
    return false;
  }

  public boolean boardfull()
  {
    int rows = this.board.length;
    int cols = this.board[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if(this.board[i][j] == 0)
          return false;
      }
    }
    return true; 
  }

  public int gameOver() {
    int rows = this.board.length;
    int cols = this.board[0].length;

    for (int i = 0; i < rows-2; i++) {
      for (int j = 0; j < cols-2; j++) {
          if(this.board[i][j] != 0)
          {
            if(fourInARow(this.turn, i, j, this.board))
              return 2;
          }
      }
    }
    return boardfull() ? 1 : 0;
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
    this.board = new int[6][7];
  }

  public void showBoard() {
    int rows = this.board.length;
    int cols = this.board[0].length;

    for (int i = 0; i < rows; i++) {
      System.out.print(" | ");
      for (int j = 0; j < cols; j++) {
        System.out.print(this.board[i][j]);
        System.out.print(" | ");
      }
      System.out.println();
    }
  }
}