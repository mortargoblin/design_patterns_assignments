import java.util.Random;

public class ExpertState implements CharacterState {
    private static final int EXPERIENCE_TO_ADVANCE = 120;

    private final Random random = new Random();

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
        if (character.getHealth() <= 10) {
            System.out.println(character.getName() + " is too weak to fight and must meditate first.");
            return;
        }
        int damage = 10 + random.nextInt(11);
        int gained = 20;
        character.addHealth(-damage);
        character.addExperience(gained);
        System.out.println(character.getName() + " fights bravely, losing " + damage
                + " health but gaining " + gained + " experience.");
        checkAdvance(character);
    }

    private void checkAdvance(GameCharacter character) {
        if (character.getExperience() >= EXPERIENCE_TO_ADVANCE) {
            character.setState(new MasterState());
        }
    }

    @Override
    public String getLevelName() {
        return "Expert";
    }

    @Override
    public String getAvailableActions() {
        return "train, meditate, fight";
    }
}
