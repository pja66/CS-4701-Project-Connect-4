public interface HeuristicAlgosInterface {

  // Overview: Provides a random score for the board layout
  // Input: void
  // Output: an int between {0,...,50}
  // ID for Minimax = 0
  public int naiveMove();

  // Overview: Generates a score based on how many connected pieces are on the
  // board
  // Input: Game
  // Output: An int representing the favorability current state of the board
  // ID for Minimax = 1
  public int maxConnected(Game currentGame);

  // Overview: Generates a value for the current state of the board based on
  // the below matrix
  //
  // ie.
  // 3 4 5 7 5 4 3
  // 4 6 8 10 8 6 4
  // 5 8 11 13 11 8 5
  // 5 8 11 13 11 8 5
  // 4 6 8 10 8 6 4
  // 3 4 5 7 5 4 3
  // Input: Game
  // Output: An int representing the favorability current state of the board
  // Source: https://file.scirp.org/Html/1-9601415_90972.htm#t1
  // ID for Minimax = 3
  public int valueCenterofBoard(Game currentGame);

  // Overview: Generates a value for the current state of the board based on
  // the below matrix
  //
  // ie.
  // 13 8 8 3 8 11 13
  // 10 5 6 4 6 8 10
  // 7 1 5 4 4 5 7
  // 10 1 4 3 4 5 7
  // 11 5 6 4 6 8 10
  // 13 8 8 5 8 11 11
  // Input: Game
  // Output: An int representing the favorability current state of the board
  // ID for Minimax = 4
  public int valueCornersofBoard(Game currentGame);
}
