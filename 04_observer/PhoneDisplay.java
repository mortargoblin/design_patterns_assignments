public class PhoneDisplay implements Observer {
    @Override
    public void update(double temperature) {
        System.out.printf("[Phone Display] Current temperature: %.1f%n", temperature);
    }
}
