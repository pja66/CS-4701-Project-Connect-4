public interface gameInterface {

  public int[][] board; // Represents the Connect4 board
  public int turn; // Variable the holds whose turn it is
  public int yellow; // Player1
  public int red; // Player2
  public int id; // GameID

  // Checks to see if the game has been won/draw
  public boolean gameOver();

  // Places move in desired column
  // Input: Numerical number indexed at 0
  // Output: True if valid move, False Else
  public boolean placeMove(int column);

  // Wipes the board of all pieces
  public void resetBoard();

  //Prints the board clearly to the terminal
  public void showBoard(int[][] board);
}