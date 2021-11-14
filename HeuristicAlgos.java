import java.lang.Math;

public class HeuristicAlgos implements HeuristicAlgosInterface {

  public HeuristicAlgos() {
  }

  public int naiveMove() {
    return (int) Math.ceil(Math.random() * 6);
  }

  private int helperHor(Game currentGame, int col, int row, int curTurn) {
    int left = col - 1;
    int right = col + 1;
    int count = 1;

    while (left > -1 && currentGame.board[row][left] == curTurn) {
      left--;
      count++;
    }

    while (right < 7 && currentGame.board[row][right] == curTurn) {
      right++;
      count++;
    }
    return count;
  }

  private int helperVert(Game currentGame, int col, int row, int curTurn) {
    int top = row + 1;
    int bot = row - 1;
    int count = 1;

    while (bot > -1 && currentGame.board[bot][col] == curTurn) {
      bot--;
      count++;
    }

    while (top < 6 && currentGame.board[top][col] == curTurn) {
      top++;
      count++;
    }
    return count;
  }

  private int helperDiag(Game currentGame, int col, int row, int curTurn) {
    int r = row - 1;
    int c = col - 1;
    int countSlopeRight = 1;

    // Going to Bottom-Left Corner
    while (r > -1 && c > -1 && currentGame.board[r][c] == curTurn) {
      c--;
      r--;
      countSlopeRight++;
    }

    r = row + 1;
    c = col + 1;
    // Going to Top-Right Corner
    while (r < 6 && c < 7 && currentGame.board[r][c] == curTurn) {
      c++;
      r++;
      countSlopeRight++;
    }

    r = row - 1;
    c = col + 1;
    int countSlopeLeft = 1;
    // Going to Bottom-Right Corner
    while (r > -1 && c < 7 && currentGame.board[r][c] == curTurn) {
      c++;
      r--;
      countSlopeLeft++;
    }

    r = row + 1;
    c = col - 1;
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
    int curTurn = gameTemp.turn;
    int score = 0;

    for(int j = 0; j < 7; j++)
    {
      gameTemp.removeMove(j);
      int row = gameTemp.placeMove(j);
      int numVert = helperVert(gameTemp, j, row, curTurn);
      int numHor = helperHor(gameTemp, j, row, curTurn);
      int numDiag = helperDiag(gameTemp, j, row, curTurn);
      score += numVert + numHor + numDiag;
    }
    return score;
  }

  public int blockLongestOppStr(Game currentGame) {
    //Need to Implement
    return 0;
  }

  public int valueCenterofBoard(Game currentGame) {
    int[][] weights = {
                      {3,4,5,7,5,4,3},
                      {4,6,8,10,8,6,4},
                      {5,8,1,13,11,8,5},
                      {5,8,1,13,11,8,5},
                      {4,6,8,10,8,6,4},
                      {3,4,5,7,5,4,3}
                      };
    int score = 0;                    
    
    for(int i = 0; i < 6; i++)
    {
      for(int j = 0; j < 7; j++)
      {
        if(currentGame.board[i][j] == currentGame.turn)
          score += weights[i][j];
      }
    }
    return score;
  }

}
