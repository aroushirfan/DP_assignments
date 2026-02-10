package state;

public class AdvancedState extends State {

    public AdvancedState(GameCharacter character) {
        super(character);
    }

    @Override
    public void showStatus() {
        System.out.println(character.getName() + " is an Advanced. XP: " + character.getXp() + ", HP: " + character.getHp());
        System.out.println("Available actions: Train, Meditate, Fight");
    }

    @Override
    public void train() {
        System.out.println(character.getName() + " trains and gains 30 XP.");
        character.increaseXp(30);
        if (character.getXp() >= 300) {
            System.out.println(character.getName() + " has leveled up to master! Game over.");
            character.setState(new MasterState(character));
        }
    }

    @Override
    public void meditate() {
        System.out.println(character.getName() + " meditates and restores 20 HP.");
        character.increaseHp(20);
        if (character.getXp() >= 300) {
            System.out.println(character.getName() + " has leveled up to master! Game over.");
            character.setState(new MasterState(character));
        }
    }

    //Expert level: In addition to training and meditating, the game character can fight when in the expert level. Fighting decreases the character's health points but increases the experience points. A certain amount of experience points is required to advance to the next level.
    //Master level: The game ends when the game character reaches the master level.
    @Override
    public void fight() {
        System.out.println(character.getName() + " fights and loses 15 HP but gains 40 XP.");
        character.decreaseHp(15);
        character.increaseXp(40);
        if (character.getXp() >= 300) {
            System.out.println(character.getName() + " has leveled up to master! Game over.");
            character.setState(new MasterState(character));
        }
        if (character.getHp() <= 0) {
            System.out.println(character.getName() + " has been defeated. Game over.");
            System.exit(0);
        }
    }
}
