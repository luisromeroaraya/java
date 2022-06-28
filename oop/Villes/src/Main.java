import models.VilleService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        VilleService service = new VilleService();
        // TODO testez vos methodes
        // getWithHighestTaxe
        System.out.println("The village with the highest taxes is: " + service.getWithHighestTaxe().getNom());
        // getCityNames
        service.getCityNames().forEach(ville -> System.out.println(ville));
        // payerTaxe
        service.getWithHighestTaxe().getHabitants().stream().filter(habitant -> habitant.getNom() == "Cament").forEach(habitant -> habitant.payerTaxe(450));
        // getMostTaxed
        System.out.println("The highest taxed habitant is: " + service.getMostTaxed().getNom());
        //
        //
    }
}
