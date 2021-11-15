public class HeuristicAlgosTest {
  public static void main(String[] args) {
    System.out.println("Tests: ");
    HeuristicAlgos test = new HeuristicAlgos();

    //NaiveTest
    System.out.println("Naive Test Suggested Col: " + (test.naiveMove() < 50));

  }
}