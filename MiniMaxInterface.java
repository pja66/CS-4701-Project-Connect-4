public interface MiniMaxInterface {
  
  //Overview: Implementation of Minimax Search Algorithm
  //Input: Game, depth of search, current game turn
  //Output: The value of the board, based on a heuristic algorithm,
  //         if a parciualr move is taken
  public int miniMaxSearch(Game curGame, int depth, int turn);


}
