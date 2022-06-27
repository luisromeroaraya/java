package models;

import interfaces.ThermoListener;

public class Thermometer {
    private int temperature;
    private ThermoListener listenerUp;
    private ThermoListener listenerDown;

    // constructors
    public Thermometer(int temperature) {
        this.temperature = temperature;
    }

    // getters
    public int getTemperature() { return temperature; }

    // setters
    public void setTemperature(int temperature) {
        int temp = this.getTemperature();
        this.temperature = temperature;
        if (temperature > temp) {
            listenerUp.notifier();
        }
        else {
            listenerDown.notifier();
        }
    }

    public void subscribeTemperatureUp(ThermoListener listener) {
        this.listenerUp = listener;
    }

    public void subscribeTemperatureDown(ThermoListener listener) {
        this.listenerDown = listener;
    }
}
