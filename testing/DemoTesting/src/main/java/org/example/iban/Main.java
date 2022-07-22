package org.example.iban;

import org.example.iban.models.Iban;

public class Main {
    public static void main(String[] args) {
        String bban = "377080141235";
        Iban iban = new Iban(bban);
        System.out.println(iban.getIban());
    }

    public static boolean verifyIban(String iban) {
        String control = iban.substring(2,4);
        System.out.println(control);
        String account = iban.substring(4);
        System.out.println(account);
        String modulo = 98 - (Long.parseLong(account + "1114" + "00") % 97) + "";
        if(modulo.equals("0"))
            return control.equals("97");
        return control.equals(modulo);
    }
}
