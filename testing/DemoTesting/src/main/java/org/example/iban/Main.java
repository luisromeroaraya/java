package org.example.iban;

import org.example.iban.models.Iban;

public class Main {
    public static void main(String[] args) {
        String bban = "377080141235";
        Iban iban = new Iban(bban);
        System.out.println(iban.getIban());
    }

    public static boolean verifyIban(String iban) {
        if(iban.length() < 16)
            throw new IllegalArgumentException("Invalid argument. Iban too short.");
        if(iban.length() > 16)
            throw new IllegalArgumentException("Invalid argument. Iban too long.");
        if(!iban.substring(0,2).equalsIgnoreCase("BE"))
            throw new IllegalArgumentException("Invalid argument. Wrong country code.");
        String control = iban.substring(2,4);
        String account = iban.substring(4);
        try {
            long number = Long.parseLong(account);
        }
        catch (NumberFormatException e){
            System.out.println("Invalid characters " + e.getMessage());
            throw new NumberFormatException("Invalid characters.");
        }
        String modulo = 98 - (Long.parseLong(account + "1114" + "00") % 97) + "";
        if(modulo.equals("0"))
            return control.equals("97");
        return control.equals(modulo);
    }
}
