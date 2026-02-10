package state;

public class IntermediateState extends State {
    public IntermediateState(GameCharacter character) {
        super(character);
    }

    @Override
    public void showStatus() {
        System.out.println(character.getName() + " is an Intermediate. XP: " + character.getXp() + ", HP: " + character.getHp());
        System.out.println("Available actions: Train, Meditate");
    }

    @Override
    public void train() {
        System.out.println(character.getName() + " trains and gains 20 XP.");
        character.increaseXp(20);
        if (character.getXp() >= 60) {
            System.out.println(character.getName() + " has leveled up to advanced!");
            character.setState(new AdvancedState(character));
        }
    }

    @Override
    public void meditate() {
        System.out.println(character.getName() + " meditates and restores 10 HP.");
        character.increaseHp(10);
    }

    @Override
    public void fight() {
        System.out.println(character.getName() + " is an intermediate and cannot fight.");
    }
}
