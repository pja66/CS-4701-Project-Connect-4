import java.util.HashMap;
import java.util.ArrayList;

public class Minimax{
  public Minimax()
  {
  }

  public int bestMove(Game curGame, int depth)
  {
    int output = -1;
    HashMap<Integer, ArrayList<Integer>> moves = new HashMap<Integer, ArrayList<Integer>>();

    for (int i = 0; i < 7; i++) {
      Game copy = new Game(curGame);
      copy.placeMove(i);
      int moveScore = miniMaxSearch(copy, depth-1, copy.otherPlayer());

      if (output < moveScore){
        ArrayList<Integer> lst = new ArrayList<Integer>();
        lst.add(i);
        moves.put(moveScore, lst);
        output = moveScore;
      }

      if(output == moveScore)
      {
        ArrayList<Integer> lst = moves.get(output);
        lst.add(i);
        moves.put(moveScore, lst);
      }
    }
    ArrayList<Integer> optMoves = moves.get(output);
    int index = (int) Math.ceil(Math.random() * (optMoves.size()-1));

    return optMoves.get(index); 
  }

  public int miniMaxSearch(Game curGame, int depth, int turn)
  {
    HeuristicAlgos algos = new HeuristicAlgos();
    //BaseCase
    if(depth <= 0 || curGame.gameOver() != 0)
    {
      int gameResult = curGame.gameOver();
      if(gameResult == 2)
        return turn == curGame.turn? -100: 100; 
      if(gameResult == 1) 
        return 0;

      return algos.naiveMove();
    }

    //Maximizing Player
    if(turn == curGame.turn) 
    {
      int maxEval = Integer.MIN_VALUE;
      Game copy = new Game(curGame);
      for(int i = 0; i < 7; i++)
      {
        copy.placeMove(i);
        int eval = miniMaxSearch(copy, depth-1, turn);
        copy.removeMove(i);
        maxEval = Math.max(maxEval, eval);
      }
      return maxEval;
    }
    //Mimimizing Player
    else 
    {
      int minEval = Integer.MAX_VALUE;
      Game copy = new Game(curGame);
      for(int i = 0; i < 7; i++)
      {
        copy.placeMove(i);
        int eval = miniMaxSearch(copy, depth-1, turn);
        copy.removeMove(i);
        minEval = Math.min(minEval, eval);
      }
      return minEval;
    }
  }
}
