public interface HeuristicAlgosInterface {

  // Overview: Suggests a uniformly Random column to place move 
  // Input: void
  // Output: an int repsenting a column element of {0,...,6}
  public int naiveMove();

  // Overview: Generates a score based on how many connected pieces are on the board 
  // Input: Game
  // Output: An int representing the favorability current state of the board 
  public int maxConnected(Game currentGame);

  // Overview: Generates a score based on how many opp. strings are blockable
  // Input: Game
  // Output: An int representing the favorability current state of the board 
  public int blockLongestOppStr(Game currentGame);


  // Overview: Generates a value for the current state of the board based on
  //           the below matrix
  //          
  //    ie. 
  //    3 4 5  7  5  4 3
  //    4 6 8  10 8  6 4
  //    5 8 11 13 11 8 5
  //    5 8 11 13 11 8 5
  //    4 6 8  10 8  6 4
  //    3 4 5  7  5  4 3
  // Input: Game
  // Output: An int representing the favorability current state of the board 
  // Source: https://file.scirp.org/Html/1-9601415_90972.htm#t1
  public int valueCenterofBoard(Game currentGame);
}
