import java.lang.Math;

public class HeuristicAlgos implements HeuristicAlgosInterface {

  public HeuristicAlgos(){}

  public int naiveMove() {
    return (int)Math.ceil(Math.random() * 6);
  }

  private int helperHor(Game currentGame, int col, int row, int curTurn) {
    int left = col-1;
    int right = col+1;
    int count = 1;

    while (left > -1 && currentGame.board[row][left] == curTurn)
    {
      left--;
      count++;
    }

    while (right < 7 && currentGame.board[row][right] == curTurn)
    {
      right++;
      count++;
    }
    return count;
  }

  private int helperVert(Game currentGame, int col, int row, int curTurn) 
  {
    int top = row+1;
    int bot = row-1;
    int count = 1;

    while (bot > -1 && currentGame.board[bot][col] == curTurn)
    {
      bot--;
      count++;
    }
    
    while (top < 6 && currentGame.board[top][col] == curTurn)
    {
      top++;
      count++;
    }
    return count;
  }

  private int helperDiag(Game currentGame, int col, int row, int curTurn) 
  {
    int r = row-1;
    int c = col-1;
    int countSlopeRight = 1; 

    // Going to Bottom-Left Corner
    while (r > -1 && c > -1 && currentGame.board[r][c] == curTurn) {
      c--;
      r--;
      countSlopeRight++;
    }

    r = row+1;
    c = col+1;
    // Going to Top-Right Corner
    while (r < 6 && c < 7 && currentGame.board[r][c] == curTurn) {
      c++;
      r++;
      countSlopeRight++;
    }

    r = row-1;
    c = col+1;
    int countSlopeLeft = 1; 
    // Going to Bottom-Right Corner
    while (r > -1 && c < 7 && currentGame.board[r][c] == curTurn) {
      c++;
      r--;
      countSlopeLeft++;
    }

    r = row+1;
    c = col-1;
    // Going to Top-left Corner
    while (r < 6 && c > -1 && currentGame.board[r][c] == curTurn) {
      c--;
      r++;
      countSlopeLeft++;
    }

    return Math.max(countSlopeRight, countSlopeLeft);
  }

  public int maxConnected(Game currentGame) {
    Game gameTemp = currentGame;
    int[] moveScore = new int[7];
    int curTurn = gameTemp.turn;

    for (int i = 0; i < 7; i++) {
      int row = gameTemp.placeMove(i);
      if (row != -1) {
        int numVert = helperVert(gameTemp, i, row, curTurn);
        int numHor = helperHor(gameTemp, i, row, curTurn);
        int numDiag = helperDiag(gameTemp, i, row, curTurn);
        
        moveScore[i] = Math.max(Math.max(numVert, numHor), numDiag);
        gameTemp.removeMove(i);
      } 
      else
        moveScore[i] = -1; // Move not possible
    }

    int max = -1;
    int index = -1; 
    for (int j = 0; j < 7; j++)
    {
     if(moveScore[j] >= max){
      max = moveScore[j];
      index = j;
     }
    }
    return index;
  }

  public int blockLongestOppStr(Game currentGame) {
    Game gameTemp = currentGame;
    gameTemp.changeTurn();
    
    return maxConnected(gameTemp);
  }
}
