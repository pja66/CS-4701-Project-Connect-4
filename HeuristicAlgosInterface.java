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
}
