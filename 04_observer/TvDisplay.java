public class TvDisplay implements Observer {
    @Override
    public void update(double temperature) {
        System.out.printf("[TV Display] Weather update -- it is now %.1f degrees outside%n", temperature);
    }
}
