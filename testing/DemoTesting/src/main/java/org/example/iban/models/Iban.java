package org.example.iban.models;

public class Iban {
    String country;
    String account;
    String control;

    // constructor
    public Iban(String account) {
        try {
            long number = Long.parseLong(account);
        }
        catch (NumberFormatException e){
            System.out.println("Invalid characters " + e.getMessage());
            throw new NumberFormatException("Invalid characters.");
        }
        if(account.length() < 12)
            throw new IllegalArgumentException("Invalid account number. BBAN account number too short.");
        if(account.length() > 12)
            throw new IllegalArgumentException("Invalid account number. BBAN account number too long.");
        if(!this.verifyBban(account))
            throw new IllegalArgumentException("Invalid account number.");
        this.country = "BE";
        this.control = calculateControl(account);
        this.account = account;
    }

    // getters
    public String getCountry() {
        return country;
    }
    public String getAccount() {
        return account;
    }
    public String getControl() {
        return control;
    }

    // methods
    public String getIban() {
        return country + control + account;
    }

    public boolean verifyBban(String account) {
        String modulo = Long.parseLong(account.substring(0, 10)) % 97 + "";
        if (modulo.equals("0"))
            return account.substring(10).equals("97");
        else
            return modulo.equals(account.substring(10));
    }

    public static String calculateControl(String account) {
        return 98 - (Long.parseLong(account + "1114" + "00") % 97) + "";
    }
}