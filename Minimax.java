public class Minimax{
  
public Minimax()
  {
  }

  public int miniMaxSearch(Game curGame, int depth, int turn)
  {
    HeuristicAlgos algos = new HeuristicAlgos();
    //BaseCase
    if(depth == 0 || curGame.gameOver() != 0)
    {
      int gameResult = curGame.gameOver();
      if(gameResult == 1)
        return turn == curGame.turn? 100: -100; 
      if(gameResult == 2) 
        return 0;

      return algos.naiveMove();
    }

    //Maximizing Player
    if(turn == curGame.turn) 
    {
      int maxEval = Integer.MIN_VALUE;
      for(int i = 0; i < 7; i++)
      {
        Game copy = curGame;
        copy.placeMove(i);
        int eval = miniMaxSearch(copy, depth-1, turn);
        copy.removeMove(i);
        maxEval = Math.max(maxEval, eval);
      }
      return maxEval;
    }
    //Mimiimizing Player
    else 
    {
      int minEval = Integer.MAX_VALUE;
      for(int i = 0; i < 7; i++)
      {
        Game copy = curGame;
        copy.placeMove(i);
        int eval = miniMaxSearch(copy, depth-1, turn);
        copy.removeMove(i);
        minEval = Math.min(minEval, eval);
      }
      return minEval;
    }
    
  }
}
