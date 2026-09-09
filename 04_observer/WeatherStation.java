import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WeatherStation extends Thread implements Subject {

    private static final double MIN_TEMPERATURE = -20.0;
    private static final double MAX_TEMPERATURE = 40.0;
    private static final long MIN_INTERVAL_MS = 1000;
    private static final long MAX_INTERVAL_MS = 5000;

    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private double temperature;
    private volatile boolean running = true;

    public WeatherStation() {
        this.temperature = MIN_TEMPERATURE + Math.random() * (MAX_TEMPERATURE - MIN_TEMPERATURE);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void stopSimulation() {
        running = false;
        this.interrupt();
    }

    @Override
    public void run() {
        while (running) {
            double delta = Math.random() < 0.5 ? -1.0 : 1.0;
            temperature = Math.max(MIN_TEMPERATURE, Math.min(MAX_TEMPERATURE, temperature + delta));
            notifyObservers();

            long sleepMillis = MIN_INTERVAL_MS + (long) (Math.random() * (MAX_INTERVAL_MS - MIN_INTERVAL_MS));
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
