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
    // initialize frame and motor variables outside the main because I'm going to use it inside a lambda function
    static Frame frame = null;
    static Motor motor = null;

    public static void main(String[] args) {
        // create Frame thread
        long time = System.currentTimeMillis();
        Thread threadFrame =
                new Thread(() -> {
                    try {
                        // simulate frame building time of 1.5 seconds suspending the execution
                        Thread.sleep(1500);
                        // create Frame
                        frame = new Frame("suv");
                        System.out.println("You built a suv type Frame in " + (System.currentTimeMillis() - time) + "ms.");
                    } catch (InterruptedException e) {
                        System.out.println("Frame sleep thread error.");
                    }
                });

        // create Motor thread
        Thread threadMotor =
                new Thread(() -> {
                    try {
                        // simulate motor building time of 2.0 seconds suspending the execution
                        Thread.sleep(2000);
                        // create Motor
                        motor = new Motor(1200);
                        System.out.println("You built a 1200cc Motor in " + (System.currentTimeMillis() - time) + "ms.");
                    } catch (InterruptedException e) {
                        System.out.println("Motor sleep thread error.");
                    }
                });

        // begin threads with start()
        threadFrame.start();
        threadMotor.start();

        try {
            // wait for frame and motor threads to finish with join()
            threadFrame.join();
            threadMotor.join();
            // create car
            Car car = new Car(frame, motor);
            System.out.println("You built a new " + car.getFrame().getType() + " type car with " + car.getMotor().getPower() + "cc of power after " + (System.currentTimeMillis() - time) + "ms.");
        } catch (InterruptedException e) {
            System.out.println("Car wasn't built.");
        }
    }
}
