import java.util.Scanner;

public class MiniMaxtest {
  public static void main(String[] args) {
    Game test = new Game(1);
    Minimax search = new Minimax();
    int depth = 8; 

    int i = 0;
    while(i < 1)
    {
      int bstMove = search.bestMove(test, depth, 0); 
      test.placeMove(bstMove);
      test.showBoard(); 
      System.out.println("______________");
      System.out.println("");

      if(test.gameOver() == 2)
      {
        System.out.println("GAME OVER");
        break;
      }

      Scanner myObj = new Scanner(System.in);  
      System.out.println("Enter Move Column");
      int col = myObj.nextInt();
      test.placeMove(col);

      if(test.gameOver() == 2)
      {
        System.out.println("GAME OVER");
        break;
      }
    }
  }
}
