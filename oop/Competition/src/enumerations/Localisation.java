package enumerations;

public enum Localisation {
    REGIONAL(25, 1000),
    NATIONAL(50, 10000),
    INTERNATIONAL(100, 100000);

    private final int limitParticipants;
    private final int prize;

    // constructors
    Localisation(int limitParticipants, int prize) {
        this.limitParticipants = limitParticipants;
        this.prize = prize;
    }

    // getters
    public int getLimitParticipants() {
        return this.limitParticipants;
    }
    public int getPrize() {
        return this.prize;
    }
}