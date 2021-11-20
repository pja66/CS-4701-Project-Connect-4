import java.util.HashMap;
import java.util.ArrayList;

public class Minimax{
  public Minimax()
  {
  }

  public int bestMove(Game curGame, int depth, int heuristic)
  {
    int output = Integer.MIN_VALUE;
    HashMap<Integer, ArrayList<Integer>> moves = new HashMap<Integer, ArrayList<Integer>>();

    for (int i = 0; i < 7; i++) {
      Game copy = new Game(curGame);

      int legalMove = copy.placeMove(i);
      if(legalMove != -1)
      {
        int moveScore = miniMaxSearch(copy, depth-1, copy.otherPlayer(), heuristic);
        System.out.println(moveScore);
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
    }

    //LEGAL MOVE RETURNED
    if(output > -1000)
    {
      ArrayList<Integer> optMoves = moves.get(output);
      int index = (int) Math.ceil(Math.random() * (optMoves.size()-1));
      return optMoves.get(index); 
    }
    else //IF NO LEGAL MOVES RETURNED 
    {
      ArrayList<Integer> lst = new ArrayList<Integer>();
      for(int i = 0; i < 7; i++)
      {
        Game copy = new Game(curGame);
        int legalMove = copy.placeMove(i);
        if(legalMove != -1)
          lst.add(i);
      }
      int index = (int) Math.ceil(Math.random() * (lst.size()-1)); 
      return lst.get(index); 
    }
  }

  public int miniMaxSearch(Game curGame, int depth, int turn, int heuristic)
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

      if(heuristic == 0)
        return algos.naiveMove();

      if(heuristic == 1)
        return algos.maxConnected(curGame);

      if(heuristic == 2)
        return algos.blockLongestOppStr(curGame);

      if(heuristic == 3)
        return algos.valueCenterofBoard(curGame);
    }

    //Maximizing Player
    if(turn == curGame.turn) 
    {
      int maxEval = Integer.MIN_VALUE;
      Game copy = new Game(curGame);
      for(int i = 0; i < 7; i++)
      {
        int eval = 0;
        int legalMove = copy.placeMove(i);
        if(legalMove == -1)
          eval = Integer.MIN_VALUE;
        else
        {
          eval = miniMaxSearch(copy, depth-1, turn, heuristic);
          copy.removeMove(i);
        }
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
        int eval = 0;
        int legalMove = copy.placeMove(i);
        if(legalMove == -1)
          eval = Integer.MAX_VALUE;
        else
        {
          eval = miniMaxSearch(copy, depth-1, turn, heuristic);
          copy.removeMove(i);
        }
        minEval = Math.min(minEval, eval);
      }
      return minEval;
    }
  }
}
