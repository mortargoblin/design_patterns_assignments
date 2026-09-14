public class IntermediateState implements CharacterState {
    private static final int EXPERIENCE_TO_ADVANCE = 70;

    @Override
    public void train(GameCharacter character) {
        int gained = 10;
        character.addExperience(gained);
        System.out.println(character.getName() + " trains and gains " + gained + " experience.");
        checkAdvance(character);
    }

    @Override
    public void meditate(GameCharacter character) {
        int healed = 15;
        character.addHealth(healed);
        System.out.println(character.getName() + " meditates and restores " + healed + " health.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println(character.getName() + " isn't skilled enough to fight yet. Train more first.");
    }

    private void checkAdvance(GameCharacter character) {
        if (character.getExperience() >= EXPERIENCE_TO_ADVANCE) {
            character.setState(new ExpertState());
        }
    }

    @Override
    public String getLevelName() {
        return "Intermediate";
    }

    @Override
    public String getAvailableActions() {
        return "train, meditate";
    }
}
