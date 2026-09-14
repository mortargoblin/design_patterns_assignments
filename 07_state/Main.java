import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            name = "Hero";
        }

        GameCharacter character = new GameCharacter(name);

        while (!character.getState().isFinal()) {
            character.printStatus();
            System.out.print("Choose an action (train / meditate / fight / quit): ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "train":
                    character.train();
                    break;
                case "meditate":
                    character.meditate();
                    break;
                case "fight":
                    character.fight();
                    break;
                case "quit":
                    System.out.println(character.getName() + " stops adventuring for now. Farewell!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown action: " + input);
            }
        }

        character.printStatus();
        System.out.println(character.getName() + " has reached the Master level. The game is complete!");
        scanner.close();
    }
}
