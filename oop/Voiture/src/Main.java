import models.Car;
import models.Frame;
import models.Motor;

//        A Car is composed of :
//        - One Motor : A Motor has a power in cc
//        - One Frame : A Frame has a type (city, berlin, break, suv)
//
//        Create an algorithm that allows to create car pieces through different threads
//        (1 thread for the Motor and 1 for the Frame)
//
//        Simulate the fact that a Motor takes 2 seconds to be built
//        The frame takes 1.5 seconds
//
//        Once all the pieces are ready, you can build your car and write it in the console

public class Main {
    // initialize frame and motor variables
    static Frame frame = null;
    static Motor motor = null;

    public static void main(String[] args) {
        // create Frame thread
        long time = System.currentTimeMillis();
        Thread threadFrame =
                new Thread(() -> {
                    // simulate frame building time of 1.5 seconds
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        System.out.println("Frame sleep thread error.");
                    }
                    // create Frame
                    frame = new Frame("suv");
                    System.out.println("You built a suv type Frame in " + (System.currentTimeMillis() - time) + "ms.");
                });
        // create Motor thread
        Thread threadMotor =
                new Thread(() -> {
                    // simulate motor building time of 2.0 seconds
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Motor sleep thread error.");
                    }
                    // create Motor
                    motor = new Motor(1200);
                    System.out.println("You built a 1200cc Motor in " + (System.currentTimeMillis() - time) + "ms.");
                });
        // begin threads with start()
        threadFrame.start();
        threadMotor.start();
        // wait for frame thread to finish with join()
        try {
            threadFrame.join();
        } catch (InterruptedException e) {
            System.out.println("The Frame wasn't built.");
        }
        // wait for motor thread to finish with join()
        try {
            threadMotor.join();
        } catch (InterruptedException e) {
            System.out.println("The Motor wasn't built.");
        }
        // create car
        Car car = new Car(frame, motor);
        System.out.println("You built a new " + car.getFrame().getType() + " type car with " + car.getMotor().getPower() + "cc of power.");
    }
}
