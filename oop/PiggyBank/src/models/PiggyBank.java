package models;

public class PiggyBank {
    private double totalMoney;

    // constructor
    public PiggyBank(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    // getters
    public double getTotalMoney() {
        return totalMoney;
    }

    // setters
    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    // methods
    public synchronized void addMoney(double money) { // synchronized protects the thread from errors adding an implicit key
        if (money > 0) {
            this.setTotalMoney(this.getTotalMoney() + money);
        }
    }
}
