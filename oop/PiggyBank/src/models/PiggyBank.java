package models;

public class PiggyBank {
    private int totalMoney;

    // constructor
    public PiggyBank(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    // getters
    public int getTotalMoney() {
        return totalMoney;
    }

    // setters
    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    // methods
    public void addMoney(int money) {
        if (money > 0) {
            synchronized ( this ) {
                this.setTotalMoney(this.getTotalMoney() + money);
            }
        }
    }
}
