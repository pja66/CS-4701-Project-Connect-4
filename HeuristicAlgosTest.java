public class HeuristicAlgosTest {
  public static void main(String[] args) {
    System.out.println("Tests: ");
    HeuristicAlgos test = new HeuristicAlgos();

    //NaiveTest 1
    System.out.println("Naive Test Suggested Col: " + (test.naiveMove() < 50));

    //MaxConnected Test 1
    Game game1 = new Game(1);
    System.out.println("maxConnected empty game: " + (0 == test.maxConnected(game1)));

    //MaxConnected Test 2
    Game game2 = new Game(1);
    game2.board[0][0] = game2.yellow;
    game2.board[0][1] = game2.yellow;
    game2.board[0][2] = game2.yellow;
    System.out.println("maxConnected 3-long String: " + (3 == test.maxConnected(game2)));

    //MaxConnected Test 3
    Game game3 = new Game(1);
    game3.board[0][0] = game3.yellow;
    game3.board[0][1] = game3.yellow;
    game3.board[0][3] = game3.yellow;
    System.out.println("maxConnected Break in String: " + (2 == test.maxConnected(game3)));

    //MaxConnected Test 4
    Game game4 = new Game(1);
    game4.board[0][0] = game4.yellow;
    game4.board[0][1] = game4.yellow;
    game4.board[1][1] = game4.yellow;
    game4.board[1][0] = game4.yellow;
    System.out.println("maxConnected 2x2 square: " + (4 == test.maxConnected(game4)));


    /* 
    MaxConnected Test 5
    | 0 | 0 | 1 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 1 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 1 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 1 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
    */
    Game game5 = new Game(1);
    game5.board[2][5] = game5.yellow;
    game5.board[3][4] = game5.yellow;
    game5.board[4][3] = game5.yellow;
    game5.board[5][2] = game5.yellow;
    System.out.println("maxConnected Diag. String: " + (4 == test.maxConnected(game5)));


  //valueCenterofBoard Test 1
  System.out.println("valueCenterofBoard Diag.: " + (34 == test.valueCenterofBoard(game5)));

  //valueCenterofBoard Test 2
  System.out.println("valueCenterofBoard 2x2 square: " + (17 == test.valueCenterofBoard(game4)));

  //valueCornersofBoard Test 1
  System.out.println("valueCornersofBoard Diag.: " + (21 == test.valueCornersofBoard(game5)));

  //valueCornersofBoard Test 2
  System.out.println("valueCornersofBoard 2x2 square: " + (36 == test.valueCornersofBoard(game4)));
  game4.showBoard();
  }
}