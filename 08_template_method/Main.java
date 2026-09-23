import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfPlayers = readNumberOfPlayers(scanner);

    new NumberGuessingGame(scanner).play(numberOfPlayers);
    scanner.close();
  }

  private static int readNumberOfPlayers(Scanner scanner) {
    while (true) {
      System.out.print("how many players (at least 2)? ");
      String input = scanner.nextLine().trim();
      try {
        int numberOfPlayers = Integer.parseInt(input);
        if (numberOfPlayers < 2) {
          System.out.println("please enter at least 2 players.");
          continue;
        }
        return numberOfPlayers;
      } catch (NumberFormatException e) {
        System.out.println("invalid number, try again.");
      }
    }
  }
}
