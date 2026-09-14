public class NoviceState implements CharacterState {
    private static final int EXPERIENCE_TO_ADVANCE = 30;

    @Override
    public void train(GameCharacter character) {
        int gained = 10;
        character.addExperience(gained);
        System.out.println(character.getName() + " trains and gains " + gained + " experience.");
        if (character.getExperience() >= EXPERIENCE_TO_ADVANCE) {
            character.setState(new IntermediateState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println(character.getName() + " doesn't know how to meditate yet. Keep training!");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println(character.getName() + " is too inexperienced to fight. Keep training!");
    }

    @Override
    public String getLevelName() {
        return "Novice";
    }

    @Override
    public String getAvailableActions() {
        return "train";
    }
}
