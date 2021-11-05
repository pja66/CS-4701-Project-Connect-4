public interface gameInterface {
  // Represents the Physical Connect4 Board
  public int[][] board = new int[6][7];
  public int turn = 0;

  // Checks to see if the game has been won/draw
  public boolean gameOver(int Turn, int[][] board);

  // Places move in desired column
  public int[][] placeMove(int column, int[][] board);

  // Wipes the board of all pieces
  public int[][] resetBoard();

  // Prints the board clearly to the terminal
  public void showBoard(int[][] board);
}