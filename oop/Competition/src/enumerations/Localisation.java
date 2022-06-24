package enumerations;

public enum Localisation {
    REGIONAL(25, 1000), // ordinal: 0
    NATIONAL(50, 10000), // ordinal: 1
    INTERNATIONAL(100, 100000); // ordinal: 2

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

    // methods
    public Localisation compare(Localisation localisation) {
        Localisation bigger = this;
        if (localisation.ordinal() > this.ordinal()) {
            bigger = localisation;
        }
        return bigger;
    }
}