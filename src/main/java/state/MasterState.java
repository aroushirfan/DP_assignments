package state;

public class MasterState extends State {

    public MasterState(GameCharacter character) {
        super(character);
    }
    //show status reached final level and exit
    @Override
    public void showStatus() {
        System.out.println(character.getName() + " is a Master. XP: " + character.getXp() + ", HP: " + character.getHp());
        System.out.println("Congratulations! You have reached the master level. Game over.");
        System.exit(0);
    }

    @Override
    public void train() {}
    @Override
    public void meditate() {}
    @Override
    public void fight() {}
}
