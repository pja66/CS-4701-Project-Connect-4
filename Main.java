public class Main {
  public static void main(String[] args) {

    Game temp = new Game(1);
    
    temp.placeMove(0);
    temp.placeMove(1);
    temp.placeMove(0);
    temp.placeMove(1);
    temp.placeMove(0);
    temp.placeMove(1);
    //temp.placeMove(0);
    temp.turn = 1;
    //temp.placeMove(1);
    temp.showBoard();


    System.out.println(temp.gameOver());
  }
}