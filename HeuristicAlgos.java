import java.lang.Math;

public class HeuristicAlgos implements HeuristicAlgosInterface {

  public HeuristicAlgos() {
  }

  public int naiveMove() {
    return (int) Math.ceil(Math.random() * 50);
  }

  public int maxConnected(Game currentGame) {
    return 0;
  }

  public int blockLongestOppStr(Game currentGame) {
    return 0;
  }

  public int valueCenterofBoard(Game currentGame) {
    int[][] weights = { { 3, 4, 5, 7, 5, 4, 3 }, { 4, 6, 8, 10, 8, 6, 4 }, { 5, 8, 1, 13, 11, 8, 5 },
        { 5, 8, 1, 13, 11, 8, 5 }, { 4, 6, 8, 10, 8, 6, 4 }, { 3, 4, 5, 7, 5, 4, 3 } };
    int score = 0;

    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 7; j++) {
        if (currentGame.board[i][j] == currentGame.turn)
          score += weights[i][j];
      }
    }
    return score;
  }

  public int valueCornersofBoard(Game currentGame) {
    int[][] weights = { { 13, 8, 8, 3, 8, 11, 13 }, { 10, 5, 6, 4, 6, 8, 10 }, { 7, 1, 5, 4, 4, 5, 7 },
        { 10, 1, 4, 3, 4, 5, 7 }, { 11, 5, 6, 4, 6, 8, 10 }, { 13, 8, 8, 5, 8, 11, 11 } };
    int score = 0;

    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 7; j++) {
        if (currentGame.board[i][j] == currentGame.turn)
          score += weights[i][j];
      }
    }
    return score;
  }
}
