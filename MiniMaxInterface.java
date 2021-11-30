public interface MiniMaxInterface {
  //Overview: First Step of the Minimax Search Algorithm. need this because
  //          We also need to keep track of the moves that are made not just 
  //          the score.
  //Input: A Game, depth of search, int which represents the heursitic you 
  //       want to use
  //Output: Column to place move. If ties, the Algo. picks amongst best chooses 
  //        randomly
  public int bestMove(Game curGame, int depth, int heuristic);

  //Overview: Implementation of Minimax Search Algorithm
  //Input: Game, depth of search, current game turn, int which represents 
  //       the heursitic you want to use, Alpha/Beta are for A&B pruing
  //Output: The value of the board, based on a heuristic algorithm,
  //         if a parciualr move is taken
  public int miniMaxSearch(Game curGame, int depth, int turn, int heuristic, int alpha, int beta);
}
