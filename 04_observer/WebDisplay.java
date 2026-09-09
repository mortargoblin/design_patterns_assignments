public class WebDisplay implements Observer {
    @Override
    public void update(double temperature) {
        System.out.printf("[Web Display] Temperature reading: %.1f C%n", temperature);
    }
}
