import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame extends Game {
  private static final int LOWER_BOUND = 1;
  private static final int UPPER_BOUND = 100;

  private final Scanner scanner;
  private final Random random = new Random();

  private int secretNumber;
  private int winner;

  public NumberGuessingGame(Scanner scanner) {
    this.scanner = scanner;
  }

  @Override
  public void initializeGame(int numberOfPlayers) {
    if (numberOfPlayers < 2) {
      throw new IllegalArgumentException("number guessing needs at least 2 players");
    }

    secretNumber = LOWER_BOUND + random.nextInt(UPPER_BOUND - LOWER_BOUND + 1);
    winner = -1;

    System.out.println("i'm thinking of a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
    System.out.println(numberOfPlayers + " players will take turns guessing it. good luck!");
  }

  @Override
  public boolean endOfGame() {
    return winner != -1;
  }

  @Override
  public void playSingleTurn(int player) {
    int guess = readGuess(player);

    if (guess == secretNumber) {
      winner = player;
      System.out.println("player " + (player + 1) + " got it!");
    } else if (guess < secretNumber) {
      System.out.println("higher!");
    } else {
      System.out.println("lower!");
    }
  }

  @Override
  public void displayWinner() {
    System.out.println("player " + (winner + 1) + " wins! the number was " + secretNumber + ".");
  }

  private int readGuess(int player) {
    while (true) {
      System.out.print("player " + (player + 1) + ", guess a number (" + LOWER_BOUND + "-" + UPPER_BOUND + "): ");
      String input = scanner.nextLine().trim();
      try {
        int guess = Integer.parseInt(input);
        if (guess < LOWER_BOUND || guess > UPPER_BOUND) {
          System.out.println("enter a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
          continue;
        }
        return guess;
      } catch (NumberFormatException e) {
        System.out.println("invalid number, try again.");
      }
    }
  }
}
