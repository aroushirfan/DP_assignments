package observer;

public class SomeObserver implements Observer{
    private String name;

    public SomeObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int temp) {
        System.out.println( name + "Current temperature: " + temp + "°C");
    }
}
