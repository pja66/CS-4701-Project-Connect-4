public interface GameInterface {
  // Overview: Checks to see if the game has been won/draw
  // Input: void
  // Output: 0 = game still in progress, 1 = tie, 2 = win
  public int gameOver();

  // Overview: Places move in desired column
  // Input: Numerical number indexed at 0
  // Output: True if valid move, False else
  public boolean placeMove(int column);

  // Wipes the board of all pieces
  // Input: void
  // Output: void
  public void resetBoard();

  // Prints the board clearly to the terminal
  // Input: void
  // Output: Terminal
  public void showBoard();
}