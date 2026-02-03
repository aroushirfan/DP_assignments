package observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Observer observer1 = new SomeObserver("Observer 1: ");
        Observer observer2 = new SomeObserver("Observer 2: ");
        Observer observer3 = new SomeObserver("Observer 3: ");

        weatherStation.addObserver(observer1);
        weatherStation.addObserver(observer2);
        weatherStation.addObserver(observer3);

        weatherStation.start();

        try {
            Thread.sleep(20000);
            weatherStation.removeObserver(observer2);
            System.out.println("Observer 2 has been removed.");
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
