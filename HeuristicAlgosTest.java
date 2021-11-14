public class HeuristicAlgosTest {
  
  public static void main(String[] args) {

    Game test0 = new Game(1);
    test0.board[0][0] = 1;
    test0.board[0][1] = 1;
    test0.board[1][1] = 1;
    test0.board[0][2] = 1;
    test0.board[1][2] = 1;
    test0.board[2][2] = 1;
    //test0.board[0][3] = 1;
    //test0.turn = 1; 
    test0.showBoard();
    test0.changeTurn();

    HeuristicAlgos temp = new HeuristicAlgos();
    System.out.println("Final Suggestion: " + temp.blockLongestOppStr(test0));

  }
}
