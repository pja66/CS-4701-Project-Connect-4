import java.util.Scanner;
public class ResearchPlayGame {
  public static void main(String[] args){
    Scanner myObj = new Scanner(System.in);
    System.out.println("");
    System.out.println("RESEARCH: ");

    System.out.println("Number of simulations");
    int sim = myObj.nextInt();

    System.out.println("Search depth for CPU 1 [1 to 8]");
    int depth1 = myObj.nextInt();

    System.out.println("Hueristic Algo for CPU 1 [0 to 3]");
    int algo1 = myObj.nextInt();

    System.out.println("Search depth for CPU 2 [1 to 8]");
    int depth2 = myObj.nextInt();

    System.out.println("Hueristic Algo for CPU 2 [0 to 3]");
    int algo2 = myObj.nextInt();

    int winsCPU1 = 0;
    int winsCPU2 = 0;
    int ties = 0;

    for(int i = 0; i < sim; i++)
    {
      int outcome = playGame(algo1, algo2, depth1, depth2);
      if(outcome == 1)
        winsCPU1 = winsCPU1+1;
      else if(outcome == 2)
        winsCPU2 = winsCPU2+1;
      else
        ties = ties+1;
    }

    System.out.println("");
    System.out.println("RESULTS: ");
    System.out.println("CPU 1 Wins: " + winsCPU1);
    System.out.println("CPU 2 Wins: " + winsCPU2);
    System.out.println("Number of ties: " + ties);
    myObj.close();
  }

  public static int playGame(int algo1, int algo2, int depth1, int depth2)
  {
    Game game = new Game(1);
    Minimax search = new Minimax();
    
    while (game.gameOver() != 1) {
      int bstMove = search.bestMove(game, depth1, algo1);
      game.placeMove(bstMove);
      if (game.gameOver() == 2) 
        return 1;
  
      int bstMove2 = search.bestMove(game, depth2, algo2);
      game.placeMove(bstMove2);
      if (game.gameOver() == 2)
        return 2;
    }
    return 0;
  }
}
