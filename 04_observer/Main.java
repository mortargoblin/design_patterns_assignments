public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherStation station = new WeatherStation();

        Observer phoneDisplay = new PhoneDisplay();
        Observer tvDisplay = new TvDisplay();
        Observer webDisplay = new WebDisplay();

        station.registerObserver(phoneDisplay);
        station.registerObserver(tvDisplay);
        station.registerObserver(webDisplay);

        station.start();

        Thread.sleep(15000);

        System.out.println("\n--- Removing TV display, it will no longer receive updates ---\n");
        station.removeObserver(tvDisplay);

        Thread.sleep(15000);

        station.stopSimulation();
        station.join();
    }
}
