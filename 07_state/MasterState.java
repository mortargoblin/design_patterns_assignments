public class MasterState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        System.out.println(character.getName() + " has already mastered the art. The game is over.");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println(character.getName() + " has already mastered the art. The game is over.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println(character.getName() + " has already mastered the art. The game is over.");
    }

    @Override
    public String getLevelName() {
        return "Master";
    }

    @Override
    public String getAvailableActions() {
        return "none - you have completed the game!";
    }

    @Override
    public boolean isFinal() {
        return true;
    }
}
