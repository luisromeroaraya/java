package models;

public class Car {
    private final Frame frame;
    private final Motor motor;

    // constructor
    public Car(Frame frame, Motor motor) {
        this.frame = frame;
        this.motor = motor;
    }

    // getters

    public Frame getFrame() {
        return frame;
    }

    public Motor getMotor() {
        return motor;
    }
}
