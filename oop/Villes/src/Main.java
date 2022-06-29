import models.VilleService;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        VilleService service = new VilleService();
        // TODO testez vos methodes
        // getWithHighestTaxe
        System.out.println("--------------------");
        System.out.println("The village with the highest taxes is: " + service.getWithHighestTaxe().getNom());
        // getCityNames
        System.out.println("--------------------");
        System.out.println("List of villages:");
        service.getCityNames()
                .forEach(ville -> System.out.println(ville));
        // payerTaxe
        System.out.println("--------------------");
        System.out.println("Making Mr Cament to pay 450...");
        service.getWithHighestTaxe()
                .getHabitants()
                .stream()
                .filter(habitant -> habitant.getNom() == "Cament")
                .forEach(habitant -> habitant.payerTaxe(450));
        // getMostTaxed
        System.out.println("--------------------");
        System.out.println("The highest taxed habitant is: " + service.getMostTaxed().getNom());
        // getStreets
        System.out.println("--------------------");
        System.out.println("List of all the streets:");
        service.getStreets()
                .forEach(street -> System.out.println(street));
        // taxe(C)
        System.out.println("--------------------");
        System.out.println("Making all the people whose Last Name begins by C to pay their taxes:");
        service.taxe('C');
        // show habitants and taxes
        System.out.println("--------------------");
        System.out.println("Showing how much taxes have people from the HighestTaxe City has paid:");
        service.getWithHighestTaxe()
                .getHabitants()
                .forEach(habitant -> System.out.println(habitant.getNom() + " has paid a total of " + habitant.getTotalTaxes() + " in taxes."));
    }
}
