public class GameTest {
  public static void main(String[] args) {
    System.out.println("Tests: ");

    // Empty Board
    Game test0 = new Game(1);
    System.out.println("Empty Board: " + (test0.gameOver() == 0)); 

    // Board is Full
    Game test1 = new Game(1); 
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 7; j++)
        test1.board[i][j] = 3;
    }
    System.out.println("Is the Board Full: " + (test1.gameOver() == 1));

    /* 
    Vertical Win
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 1 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 1 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 1 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 1 | 0 | 0 | 0 | 0 | 0 | 0 | 
    */
    Game test2 = new Game(1);
    for (int i = 0; i < 4; i++) {
      test2.board[i][0] = test2.yellow;
    }
    System.out.println("Vertical Win: " + (test2.gameOver() == 2));

    /*
    Horizontal Win
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 1 | 1 | 1 | 1 | 0 | 0 | 0 | 
    */
    Game test3 = new Game(1);
    for (int j = 0; j < 4; j++) {
      test3.board[0][j] = test3.yellow;
    }
    System.out.println("Horizontal Win: " + (test3.gameOver() == 2));

    /* 
    Diagonal Win
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 1 | 0 | 0 | 0 | 
    | 0 | 0 | 1 | 0 | 0 | 0 | 0 | 
    | 0 | 1 | 0 | 0 | 0 | 0 | 0 | 
    | 1 | 0 | 0 | 0 | 0 | 0 | 0 |
    */
    Game test4 = new Game(1);
    for (int j = 0; j < 4; j++) {
      test4.board[j][j] = test4.yellow;
    }
    System.out.println("Diagonal Win: " + (test4.gameOver() == 2));

    // Turn Change
    Game test5 = new Game(1);
    test5.placeMove(1);
    System.out.println("Turn Change: " + (test5.turn == test5.red));

    // No Turn Change
    Game test6 = new Game(1);
    test6.placeMove(1);
    test6.placeMove(1);
    test6.placeMove(1);
    test6.placeMove(1);
    test6.placeMove(1);
    test6.placeMove(1);
    int currentTurn = test6.turn;
    test6.placeMove(1);
    System.out.println("No Turn Change: " + (currentTurn == test6.turn));

    /* 
    Vertical 2
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 1 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 1 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 1 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 1 |
    */
    Game test7 = new Game(1);
    test7.board[0][6] = test7.yellow;
    test7.board[1][6] = test7.yellow;
    test7.board[2][6] = test7.yellow;
    test7.board[3][6] = test7.yellow;
    System.out.println("Vertical 2: " + (test7.gameOver() == 2));

    /* 
    Horizontal 2
    | 0 | 0 | 1 | 1 | 1 | 1 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
    */
    Game test8 = new Game(1);
    test8.board[5][5] = test8.yellow;
    test8.board[5][4] = test8.yellow;
    test8.board[5][3] = test8.yellow;
    test8.board[5][2] = test8.yellow;
    System.out.println("Horizontal 2: " + (test8.gameOver() == 2));

    /* 
    Diagonal 2
    | 0 | 0 | 0 | 0 | 0 | 0 | 1 | 
    | 0 | 0 | 0 | 0 | 0 | 1 | 0 | 
    | 0 | 0 | 0 | 0 | 1 | 0 | 0 | 
    | 0 | 0 | 0 | 1 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
    */
    Game test9 = new Game(1);
    test9.board[5][6] = test9.yellow;
    test9.board[4][5] = test9.yellow;
    test9.board[3][4] = test9.yellow;
    test9.board[2][3] = test9.yellow;
    System.out.println("Diagonal 2: " + (test9.gameOver() == 2));

    // RemoveMove 1
    Game test10 = new Game(1);
    System.out.println("RemoveMove 1: " +(test10.removeMove(0) == -1));

    // RemoveMove 2
    Game test11 = new Game(1);
    test11.placeMove(0);
    test11.removeMove(0);
    System.out.println("RemoveMove 2: " + (test11.board[0][0] == 0));

    // RemoveMove turn change
    Game test12 = new Game(1);
    test12.placeMove(1);
    test12.removeMove(1);
    System.out.println("RemoveMove3 : " + (test12.turn == test12.yellow));
  }
}