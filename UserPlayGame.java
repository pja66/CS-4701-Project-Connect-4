import java.util.Scanner;

public class UserPlayGame {
  public static void main(String[] args) throws InterruptedException{
    // Game Interface Setup
    Scanner myObj = new Scanner(System.in);
   
    System.out.println(" ");
    System.out.println("Welcome to ");                                                         
    System.out.println(" |\\/| o ._  o |\\/|  /\\  \\/  /   _  ._   _   _ _|_ |_|_ | | | ");
    System.out.println(" |  | | | | | |  | /--\\ /\\  \\_ (_) | | (/_ (_  |_   |  o o o ");
    System.out.println(" ");                                        

    System.out.println("Press 1 to play Connect4, or 2 for the directions");
    int whiteSheet = myObj.nextInt();
    if(whiteSheet == 2)
    {
      System.out.println("IMPLEMENT DIRECTIONS/INFO");
    }

    System.out.println("Press 1 for Hum Vs. CPU, 2 for CPU Vs. CPU");
    int playAI = myObj.nextInt();
    while(playAI != 1 && playAI != 2)
    {
      System.out.println("Please enter 1 or 2: ");
      playAI = myObj.nextInt();
    }

    // Human Vs. CPU
    if (playAI == 1) {
      Game game = new Game(1);
      Minimax search = new Minimax();

      System.out.println("Enter an number for search depth [0 to 8]");
      int depth = myObj.nextInt();

      System.out.println("Enter an number for a Hueristic Algorithm [0 to 3]");
      int id = myObj.nextInt();

      while(game.gameOver() != 1) {
        int bstMove = search.bestMove(game, depth, id);
        game.placeMove(bstMove);
        game.showBoard();

        System.out.println("______________");
        System.out.println("");

        if (game.gameOver() == 2) {
          System.out.println("CPU WON! GAME OVER");
          break;
        }
        System.out.println("Enter Move Column");
        int col = myObj.nextInt();
        int legalMove =  game.placeMove(col);

        while(legalMove == -1)
        {
          System.out.println("Please Enter a Valid Column");
          col = myObj.nextInt();
          legalMove =  game.placeMove(col);
        }

        if (game.gameOver() == 2) {
          System.out.println("______________");
          System.out.println("");
          game.showBoard();
          System.out.println("YOU WON! GAME OVER");
          break;
        }
      }
      if(game.gameOver() == 1)
        System.out.println("TIE!");
    } 
    //CPU Vs. CPU
    else if (playAI == 2) {
      Game game = new Game(1);
      Minimax search = new Minimax();

      System.out.println("Enter an number for search depth of CPU 1 [0 to 8]");
      int depth1 = myObj.nextInt();

      System.out.println("Enter an number for a Hueristic Algorithm for CPU 1 [0 to 3]");
      int id1 = myObj.nextInt();

      System.out.println("Enter an number for search depth CPU 2 (0 to 8)");
      int depth2 = myObj.nextInt();

      System.out.println("Enter an number for a Hueristic Algorithm for CPU 2 [0 to 3]");
      int id2 = myObj.nextInt();

      while (game.gameOver() != 1) {
        int bstMove = search.bestMove(game, depth1, id1);
        game.placeMove(bstMove);

        if (game.gameOver() == 2) {
          game.showBoard();
          System.out.println("CPU 1 WON, GAME OVER");
          break;
        }
        game.showBoard();
        System.out.println("");
        Thread.sleep(2000);

        int bstMove2 = search.bestMove(game, depth2, id2);
        game.placeMove(bstMove2);

        if (game.gameOver() == 2) {
          game.showBoard();
          System.out.println("CPU 2 WON, GAME OVER");
          break;
        }

        game.showBoard();
        System.out.println("");
        Thread.sleep(2000);
      }

      if(game.gameOver() == 1)
        System.out.println("ITS A TIE!");
    }
  }
}
