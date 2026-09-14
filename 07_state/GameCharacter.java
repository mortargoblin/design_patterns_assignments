public class GameCharacter {
    private static final int MAX_HEALTH = 100;

    private final String name;
    private int experience;
    private int health;
    private CharacterState state;

    public GameCharacter(String name) {
        this.name = name;
        this.experience = 0;
        this.health = MAX_HEALTH;
        this.state = new NoviceState();
    }

    public void train() {
        state.train(this);
    }

    public void meditate() {
        state.meditate(this);
    }

    public void fight() {
        state.fight(this);
    }

    public void setState(CharacterState state) {
        this.state = state;
        System.out.println(">> " + name + " has advanced to the " + state.getLevelName() + " level!");
    }

    public void addExperience(int amount) {
        experience += amount;
    }

    public void addHealth(int amount) {
        health = Math.min(MAX_HEALTH, Math.max(0, health + amount));
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public CharacterState getState() {
        return state;
    }

    public void printStatus() {
        System.out.println("----------------------------------------");
        System.out.println(name + " | Level: " + state.getLevelName()
                + " | Experience: " + experience + " | Health: " + health);
        System.out.println("Available actions: " + state.getAvailableActions());
    }
}
