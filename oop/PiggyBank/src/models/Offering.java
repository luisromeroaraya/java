package models;

public class Offering extends Thread {
    private PiggyBank bank;
    private double money;
    private int seconds;
    private boolean running;

    // constructor
    public Offering(PiggyBank bank, double money, int seconds) {
        this.bank = bank;
        this.money = money;
        this.seconds = seconds;
        this.running = true;
    }

    // getters
    public PiggyBank getBank() {
        return bank;
    }

    public double getMoney() {
        return money;
    }

    public int getSeconds() {
        return seconds;
    }

    public boolean isRunning() {
        return running;
    }

    // setters
    public synchronized void setRunning(boolean running) { this.running = running; }

    // methods
    public void run() {
        try {
            while(this.isRunning()) { // the user can change this boolean to stop this loop
                Thread.sleep(this.getSeconds()*1000L);
                this.getBank().addMoney(this.getMoney());
            }
        } catch (InterruptedException e) {
            System.out.println("Error receiving the Offering.");
        }
    }
}
