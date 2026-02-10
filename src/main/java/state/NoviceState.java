package state;

public class NoviceState extends State{
    public NoviceState(GameCharacter character) {
        super(character);
    }
    @Override
    public void showStatus() {
        System.out.println(character.getName() + " is a Novice. XP: " + character.getXp() + ", HP: " + character.getHp());
        System.out.println("Available actions: Train");
    }

    @Override
    public void train() {
        System.out.println(character.getName() + " trains and gains 10 XP.");
        character.increaseXp(10);
        if (character.getXp() >= 30) {
            System.out.println(character.getName() + " has leveled up to intermediate!");
            character.setState(new IntermediateState(character));
        }
    }

    @Override
    public void meditate() {
        System.out.println(character.getName() + " is a novice and cannot meditate.");
    }

    @Override
    public void fight() {
        System.out.println(character.getName() + " is a novice and cannot fight.");
    }
}
