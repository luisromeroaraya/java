//Créez une classe Tirelire.
//        Cette tirelire contiendra une certaine quantité d'argent.
//        Créez une classe Etrenne (enfant de Thread) qui va rajoute
//        tous les X temps(en secondes) une certaine qtt d'argent dans une
//        certaine tirelire.
//
//        Il devra aussi être possible d'arrêter une Etrenne.
//
//        Faite en sorte que les classes créées soient Thread Safe.

import models.Offering;
import models.PiggyBank;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PiggyBank bank = new PiggyBank(0);
        Offering offering = new Offering(bank,100, 1);
        offering.start();

        System.out.println(offering.getMoney() + " euros are being transfered to your bank every " + offering.getSeconds() + " seconds.");
        System.out.print("Do you want to stop the Offering? (y/n): ");
        Scanner input = new Scanner(System.in);
        String stop = input.nextLine().toLowerCase(Locale.ROOT);
        if (stop.startsWith("y")) {
            offering.setRunning(false);
        }
        System.out.println("Money received: " + bank.getTotalMoney() + " euros.");
    }
}
