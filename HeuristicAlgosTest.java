public class HeuristicAlgosTest {
  public static void main(String[] args) {
    System.out.println("Tests: ");
    HeuristicAlgos test = new HeuristicAlgos();

    //NaiveTest
    System.out.println("Naive Test Suggested Col: " + test.naiveMove());

    //BlockLongestOppStr 1
    Game test1 = new Game(1);
    System.out.println("Block test 1: " + (test.blockLongestOppStr(test1)));

    /*
    BlockLongestOppStr 2
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | * | 2 | 2 | 2 | 0 | 0 | 0 | 
    */
     Game test2 = new Game(1);
     test2.board[0][1] = 2;
     test2.board[0][2] = 2;
     test2.board[0][3] = 2;
     System.out.println("Block test 2: " + (test.blockLongestOppStr(test2)));

    /*
    BlockLongestOppStr 3
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | * | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 2 | 0 | 0 | 0 | 0 | 
    | 0 | 2 | 2 | 0 | 0 | 0 | 0 | 
    | 0 | 2 | 2 | 0 | 0 | 0 | 0 | 
    */
     Game test3 = new Game(1);
     test3.board[0][1] = 2;
     test3.board[0][2] = 2;
     test3.board[1][1] = 2;
     test3.board[1][2] = 2;
     test3.board[2][2] = 2;
     System.out.println("Block test 3: " + (test.blockLongestOppStr(test3)));

    /*
    BlockLongestOppStr 4
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | * | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 1 | 0 | 0 | 0 | 0 | 
    | 0 | 1 | 1 | 0 | 0 | 0 | 0 | 
    | 1 | 1 | 1 | 0 | 0 | 0 | 0 | 
    */
    Game test4 = new Game(1);
    test4.board[0][0] = 1;
    test4.board[0][1] = 1;
    test4.board[1][1] = 1;
    test4.board[0][2] = 1;
    test4.board[1][2] = 1;
    test4.board[2][2] = 1;
    test4.changeTurn();
    System.out.println("Block test 4: " + (test.blockLongestOppStr(test4)));

    //MaxConnected 1
    Game test5 = new Game(1);
    System.out.println("MaxConnected test 1: " + (test.maxConnected(test5)));

    /*
    MaxConnected 2
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | * | 1 | 1 | 1 | 0 | 0 | 0 | 
    */
    Game test6 = new Game(1);
    test6.board[0][1] = 1;
    test6.board[0][2] = 1;
    test6.board[0][3] = 1;
    System.out.println("MaxConnected test 1: " + (test.maxConnected(test6)));

    /*
    MaxConnected 3
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
    | 0 | 0 | * | 0 | 0 | 0 | 0 | 
    | 0 | 0 | 2 | 0 | 0 | 0 | 0 | 
    | 0 | 2 | 2 | 0 | 0 | 0 | 0 | 
    | 0 | 2 | 2 | 0 | 0 | 0 | 0 | 
    */
    Game test7 = new Game(1);
    test7.board[0][1] = 2;
    test7.board[0][2] = 2;
    test7.board[1][1] = 2;
    test7.board[1][2] = 2;
    test7.board[2][2] = 2;
    test7.turn = 2;
    System.out.println("MaxConnected test 3: " + (test.maxConnected(test7)));

   /*
   MaxConnected 4
   | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
   | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
   | 0 | 0 | * | 0 | 0 | 0 | 0 | 
   | 0 | 0 | 1 | 0 | 0 | 0 | 0 | 
   | 0 | 1 | 1 | 0 | 0 | 0 | 0 | 
   | 1 | 1 | 1 | 0 | 0 | 0 | 0 | 
   */
   Game test8 = new Game(1);
   test8.board[0][0] = 1;
   test8.board[0][1] = 1;
   test8.board[1][1] = 1;
   test8.board[0][2] = 1;
   test8.board[1][2] = 1;
   test8.board[2][2] = 1;
   System.out.println("MaxConnected test 4: " + (test.maxConnected(test8)));

  /*
   valueCenterofBoard 1
   | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
   | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
   | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
   | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
   | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
   | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
   */
  Game test9 = new Game(1); 
  System.out.println("valueCenterofBoard test 1: " + (test.valueCenterofBoard(test9) == 0));

  //valueCenterofBoard 2
  Game test10 = new Game(1); 
  test10.board[0][3] = 1;
  System.out.println("valueCenterofBoard test 2: " + (test.valueCenterofBoard(test10) == 7));

  /*
   valueCenterofBoard 3
   | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
   | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
   | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
   | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
   | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
   | 0 | 0 | 0 | 1 | 0 | 0 | 0 | 
   */
  Game test11 = new Game(1); 
  test11.board[0][3] = 1;
  test11.changeTurn();
  System.out.println("valueCenterofBoard test 3: " + (test.valueCenterofBoard(test11) == 0));
  }
}