public interface GameInterface {
  // Overview: Checks to see if the game has been won/draw
  // Input: void
  // Output: 0 = game still in progress, 1 = tie, 2 = win
  public int gameOver();

  // Overview: Changes the turn field to the other player
  // Input: void
  // Output: void
  public void changeTurn();

  // Overview: Places move in desired column and changes turn
  // Input: Numerical number indexed at 0
  // Output: Row index if of move if move is valid(Column not filled), -1 else
  public int placeMove(int column);

  // Overview: Removes move in desired column and changes turn back
  // Input: Numerical number indexed at 0
  // Output: Row index of remove if valid remove (Move exist in that column)
  // -1 else
  public int removeMove(int column);

  // Wipes the board of all pieces
  // Input: void
  // Output: void
  public void resetBoard();

  // Prints the board clearly to the terminal
  // Input: void
  // Output: Terminal
  public void showBoard();
}