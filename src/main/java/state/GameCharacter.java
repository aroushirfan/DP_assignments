package state;

public class GameCharacter {
    private String name;
    private int xp;
    private int hp;
    private State state;

    public GameCharacter(String name) {
        this.name = name;
        this.xp = 0;
        this.hp = 100;
        this.state = new NoviceState(this);
    }
    public String getName() {return name;}
    public int getXp() {return xp;}
    public int getHp() {return hp;}
    public void increaseXp(int amount) {xp += amount;}
    public void increaseHp(int amount) {hp += amount;}
    public void decreaseHp(int amount) {hp -= amount;}
    public void setState(State state) {this.state = state;}
    public void showStatus() {state.showStatus();}
    public void train() {state.train();}
    public void meditate() {state.meditate();}
    public void fight() {state.fight();}

}
