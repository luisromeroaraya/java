package models;

public class Offering extends Thread {
    private PiggyBank bank;
    private int money;
    private int seconds;
    private boolean running;

    // constructor
    public Offering(PiggyBank bank, int money, int seconds) {
        this.bank = bank;
        this.money = money;
        this.seconds = seconds;
        this.running = true;
    }

    // getters
    public PiggyBank getBank() {
        return bank;
    }

    public int getMoney() {
        return money;
    }

    public int getSeconds() {
        return seconds;
    }

    public boolean isRunning() {
        return running;
    }

    // setters
    public void setRunning(boolean running) {
        synchronized (this) {
            this.running = running;
        }
    }

    // methods
    public void run() {
        try {
            while(this.isRunning()) {
                Thread.sleep(this.getSeconds()*1000L);
                this.getBank().addMoney(this.getMoney());
//                System.out.println("You received " + this.getMoney() + " euros.");
//                System.out.println("New total: " + this.getBank().getTotalMoney() + " euros.");
//                 System.out.println( Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            System.out.println("Error receiving the Offering.");
        }
    }
}
