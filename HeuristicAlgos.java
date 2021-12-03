import java.lang.Math;
import java.util.*;

public class HeuristicAlgos implements HeuristicAlgosInterface {

  public HeuristicAlgos() {
  }

  public int naiveMove() {
    return (int) Math.ceil(Math.random() * 50);
  }

  public int maxConnected(Game currentGame) {
    boolean[][] seen = new boolean[6][7];
    int maxCount = 0;

    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 7; j++) {
        if (currentGame.board[i][j] == currentGame.turn && !seen[i][j]) {
          int count = 0;
          Stack<int[]> stack = new Stack<>();
          int[] index = { i, j };
          stack.add(index);

          while (stack.size() != 0) {
            int[] temp = stack.pop();
            int row = temp[0];
            int col = temp[1];

            if(!seen[row][col]) {
              count += 1;
              seen[row][col] = true;

              for (int r = -1; r < 2; r++) {
                for (int c = -1; c < 2; c++) {
                  if (((row + r) > -1) && ((row + r) < 6) && ((col + c) > -1) && ((col + c) < 7)) {
                   try{
                    if (currentGame.board[(row + r)][(col + c)] == currentGame.turn && !seen[(row + r)][col + c]) {
                      int[] temp2 = { (row + r), (col + c) };
                      stack.add(temp2);
                    }
                    }
                    catch (ArrayIndexOutOfBoundsException exception){
                      System.out.println("THis is row: " + (row + r));
                      System.out.println("THis is col: " + (col + c));
                    }
                  }
                }
              }
            }
          }
          maxCount = Math.max(maxCount, count);
        }
      }
    }
    return maxCount;
  }

  public int valueCenterofBoard(Game currentGame) {
    int[][] weights = { { 3, 4, 5, 7, 5, 4, 3 }, 
                        { 4, 6, 8, 10, 8, 6, 4 }, 
                        { 5, 8, 1, 13, 11, 8, 5 },
                        { 5, 8, 1, 13, 11, 8, 5 }, 
        { 4, 6, 8, 10, 8, 6, 4 }, { 3, 4, 5, 7, 5, 4, 3 } };
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
    int[][] weights = { { 13, 8, 8, 3, 8, 11, 13 }, 
                        { 10, 5, 6, 4, 6, 8, 10 }, 
                        { 7, 1, 5, 4, 4, 5, 7 },
                        { 10, 1, 4, 3, 4, 5, 7 }, 
                        { 11, 5, 6, 4, 6, 8, 10 }, 
                        { 13, 8, 8, 5, 8, 11, 11 } };
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
