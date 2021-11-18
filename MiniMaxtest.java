public class MiniMaxtest {
  public static void main(String[] args) {
    Game test = new Game(1);
    Minimax search = new Minimax();

    test.board[0][3] = 1;
    test.board[0][2] = 1;
    test.board[0][1] = 1;
    test.board[1][1] = -1;

    int bstMove = search.bestMove(test, 2);
    test.showBoard(); 

    System.out.println(bstMove);

  }
}
