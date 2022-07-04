import models.Thermometer;

public class Main {
    public static void main(String[] args) {
        Thermometer thermometer = new Thermometer(20);
        System.out.println("Hello, the temperature is: " + thermometer.getTemperature() + "°C");
        thermometer.subscribeTemperatureUp(() -> {
            System.out.println("The temperature went up");
            System.out.println("The temperature is now " + thermometer.getTemperature() + "°C");
        });
        thermometer.subscribeTemperatureDown(() -> {
            System.out.println("The temperature went down");
            System.out.println("The temperature is now " + thermometer.getTemperature() + "°C");
        });
        thermometer.setTemperature(24);
        thermometer.setTemperature(23);
    }
}
