public class MiniMaxtest {
  public static void main(String[] args) {
    Game test = new Game(1);
    Minimax search = new Minimax();
  
    for(int turns = 0; turns < 5; turns++)
    {
    int output = -1;
    int oppIndex = -1;

    for(int i = 0; i < 7; i++)
    {
      
      test.placeMove(i);
      int moveScore = search.miniMaxSearch(test, 5, test.turn);
      test.removeMove(i);

      if(output < moveScore)
      {
        oppIndex = i;
        output = moveScore;
      }
    }

    test.placeMove(oppIndex);
    if(test.gameOver() == 2)
    {
      System.out.println("OVEEERRR" + test.turn);
    }
  }
   
  test.showBoard();
  }
}
