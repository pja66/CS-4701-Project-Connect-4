import java.util.Scanner;

public class UserPlayGame {
  public static void main(String[] args) throws InterruptedException {
    // Game Interface Setup
    Scanner myObj = new Scanner(System.in);

    System.out.println(" ");
    System.out.println("__      __   _                    _        ");
    System.out.println("\\ \\    / /__| |__ ___ _ __  ___  | |_ ___  ");
    System.out.println(" \\ \\/\\/ / -_) / _/ _ \\ '  \\/ -_) |  _/ _ \\ ");
    System.out.println("  \\_/\\_/\\___|_\\__\\___/_|_|_\\___|  \\__\\___/ ");
                                               
   
    System.out.println(" ");


    
    System.out.println("  __  __ _      _ __  __           ___                      _   _ _  _ _ _ ");
    System.out.println(" |  \\/  (_)_ _ (_)  \\/  |__ ___ __/ __|___ _ _  _ _  ___ __| |_| | || | | |");
    System.out.println(" | |\\/| | | ' \\| | |\\/| / _` \\ \\ / (__/ _ \\ ' \\| ' \\/ -_) _|  _|_  _|_|_|_|");
    System.out.println(" |_|  |_|_|_||_|_|_|  |_\\__,_/_\\_\\\\___\\___/_||_|_||_\\___\\__|\\__| |_|(_|_|_)");
                                                                              
   



    System.out.println(" ");

    System.out.println("Press 1 to play Connect4, or 2 for the directions");
    int whiteSheet = myObj.nextInt();
    System.out.println(" ");

    if (whiteSheet == 2) {
      System.out.println("______________");
      System.out.println("");
      System.out.println("Parameters of the game: ");
      System.out.println("");

      System.out.println("  Heuristic Algorithmns:");
      System.out.println("  You can choose whole numbers between 0 and 3:"); 

      System.out.println("    0 - naiveMove");
      System.out.println("      The CPU makes random moves against you");
      System.out.println("    1 - maxConnected");
      System.out.println("      The CPU makes moves the result in the most connected structure of pieces"); 
      System.out.println("    2 - valueCenterofBoard");
      System.out.println("      The CPU makes moves that value the center of the board");
      System.out.println("    3 - valueCornersofBoard");
      System.out.println("      The CPU makes moves that value the corner of the board");
      System.out.println("");

      System.out.println("  Search Depth:");
      System.out.println("  You can choose whole numbers between 0 and 8:"); 
      System.out.println("    0 - easiest"); 
      System.out.println("      ... "); 
      System.out.println("    8 - hardest");
      System.out.println("");

      System.out.println("______________");
      System.out.println("");
    }
    System.out.println("Press 1 for Human Vs. CPU, 2 for CPU Vs. CPU");
    int playAI = myObj.nextInt();
    System.out.println(" ");

    while (playAI != 1 && playAI != 2) {
      System.out.println("Please enter 1 or 2: ");
      playAI = myObj.nextInt();
      System.out.println(" ");
    }

    // Human Vs. CPU
    if (playAI == 1) {
      Game game = new Game(1);
      Minimax search = new Minimax();

      System.out.println("Enter a number for search depth [1 to 8]");
      int depth = myObj.nextInt();
      System.out.println(" ");

      System.out.println("Enter a number for a Heuristic Algorithm [0 to 3]");
      int id = myObj.nextInt();
      System.out.println(" ");

      while (game.gameOver() != 1) {
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
        int legalMove = game.placeMove(col);
        System.out.println("");

        while (legalMove == -1) {
          System.out.println("Please Enter a Valid Column");
          col = myObj.nextInt();
          legalMove = game.placeMove(col);
          System.out.println("");
        }

        if (game.gameOver() == 2) {
          System.out.println("______________");
          System.out.println("");
          game.showBoard();
          System.out.println("YOU WON! GAME OVER");
          System.out.println("");
          break;
        }
      }
      if (game.gameOver() == 1)
        System.out.println("TIE!");
    }
    // CPU Vs. CPU
    else if (playAI == 2) {
      Game game = new Game(1);
      Minimax search = new Minimax();

      System.out.println("Enter a number for search depth of CPU 1 [1 to 8]");
      int depth1 = myObj.nextInt();
      System.out.println(" ");

      System.out.println("Enter an number for a Heuristic Algorithm for CPU 1 [0 to 3]");
      int id1 = myObj.nextInt();
      System.out.println(" ");

      System.out.println("Enter a number for search depth CPU 2 (1 to 8)");
      int depth2 = myObj.nextInt();
      System.out.println(" ");

      System.out.println("Enter a number for a Hueristic Algorithm for CPU 2 [0 to 3]");
      int id2 = myObj.nextInt();
      System.out.println(" ");

      while (game.gameOver() != 1) {
        int bstMove = search.bestMove(game, depth1, id1);
        game.placeMove(bstMove);

        if (game.gameOver() == 2) {
          game.showBoard();
          System.out.println("CPU 1 WON! GAME OVER");
          break;
        }
        game.showBoard();
        System.out.println("______________");
        System.out.println("");
        Thread.sleep(2000);

        int bstMove2 = search.bestMove(game, depth2, id2);
        game.placeMove(bstMove2);

        if (game.gameOver() == 2) {
          game.showBoard();
          System.out.println("CPU 2 WON! GAME OVER");
          break;
        }

        game.showBoard();
        System.out.println("______________");
        System.out.println("");
        Thread.sleep(2000);
      }

      if (game.gameOver() == 1)
        System.out.println("ITS A TIE!");
    }
    myObj.close();
  }
}
