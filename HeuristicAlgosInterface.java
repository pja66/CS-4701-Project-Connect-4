public interface HeuristicAlgosInterface {

  // Overview: Suggests a uniformly Random column to place move. 
  // Input: void
  // Output: an int repsenting a column element of {0,...,6}
  public int naiveMove();

  // Overview: Suggests a move based on how many connected pieces the move 
  //            creates. (ie. 1, 2, 3, 4). If a tie, picks first column from 
  //            tied moves.
  // Input: Game
  // Output: an int repsenting a column element of {0,...,6}
  public int maxConnected(Game currentGame);

  // Overview: Suggests a move based on the ability to block the opponents 
  //           longest string of peices. If a tiepicks first column from 
  //            tied moves.
  // Input: Game
  // Output: an int repsenting a column element of {0,...,6}
  public int blockLongestOppStr(Game currentGame);


  // Overview: Suggests a move based on the proximity of the move to the center
  //           of the board:
  //    ie. 
  //    3 4 5  7  5  4 3
  //    4 6 8  10 8  6 4
  //    5 8 11 13 11 8 5
  //    5 8 11 13 11 8 5
  //    4 6 8  10 8  6 4
  //    3 4 5  7  5  4 3
  // Input: Game  
  // Output: an int repsenting a column element of {0,...,6}
  // Source: https://file.scirp.org/Html/1-9601415_90972.htm#t1
  public int valueCenterofBoard(Game currentGame);
}
