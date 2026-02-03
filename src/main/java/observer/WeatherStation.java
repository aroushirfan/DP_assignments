package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread {
    private List<Observer> observers = new ArrayList<>();
    private int temp;
    private final int minTemp = -20;
    private final int maxTemp = 30;
    private Random random = new Random();

    public WeatherStation() {
        this.temp = random.nextInt(30) - 10;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temp);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((random.nextInt(5) + 1) * 1000);
                int change = random.nextInt(5) - 2;
                temp += change;
                if (temp > maxTemp) {
                    temp = maxTemp;
                }else if (temp < minTemp) {
                    temp = minTemp;
                }
                notifyObservers();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
