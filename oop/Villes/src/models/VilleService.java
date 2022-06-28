package models;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VilleService {
    private Collection<Ville> villes;

    // constructors
    public VilleService() {
        setup();
    }

    // methods
    public void setup(){
        List<Habitant> hegiature = List.of(
                new Habitant("Moore", "Thierry", "rue Barbe", 86),
                new Habitant("Kimtsaris", "Alexandre", "rue Barbe", 207),
                new Habitant("Cabuchon", "Melanie", "rue Vazy", 49),
                new Habitant("Colat", "Thierry", "rue Barbe", 86),
                new Habitant("Zaine", "Aude", "boulevard Icelle", 158)
        );

        List<Habitant> brequin = List.of(
                new Habitant("Delpeche", "Maude", "rue Stique", 128),
                new Habitant("Otor", "Amine", "avenue Truc", 64),
                new Habitant("Delince", "Jean", "avenue Truc", 7),
                new Habitant("Tovarovitch", "Mélodie", "rue Bonhomme", 2),
                new Habitant("Richard", "Nathan", "avenue Truc", 64),
                new Habitant("Rapier", "William", "rue Machin", 128)
        );

        List<Habitant> quithyme = List.of(
                new Habitant("Harrison", "Paul", "rue du Passage", 207),
                new Habitant("Cament", "Medhi", "rue du Passage", 200),
                new Habitant("Richard", "Nathan", "avenue Truc", 64)
        );

        this.villes = List.of(
                new Ville(1000, "Hégiature", hegiature, 1500),
                new Ville(2510, "Brequin", brequin, 800),
                new Ville(9510, "Quityme", quithyme, 3000)
        );
    }

    public Ville getWithHighestTaxe() {
        // TODO retourner la ville ou la taxe est la plus grande ou null si il n'y a pas de ville
        return villes.stream()
                .max(Comparator.comparing(Ville::getMontantTaxe)).get();
    }

    public List<String> getCityNames(){
        // TODO retourner la liste des noms des villes
        return villes.stream()
                .map(ville -> ville.getNom())
                .collect(Collectors.toList());
    }

    public Habitant getMostTaxed(){
        // TODO Retourner l'habitant qui le plus été taxé ou lancer une RuntimeException
//        return villes.stream()
//                .map(ville -> ville.getHabitants()
//                        .stream()
//                        .max(Comparator.comparingDouble(Habitant::getTotalTaxes))
//                        .get()
//                )
//                .max(Comparator.comparingDouble(Habitant::getTotalTaxes))
//                .get();
        return  villes.stream()
                .flatMap(ville -> ville.getHabitants().stream())
                .max(Comparator.comparingDouble(Habitant::getTotalTaxes))
                .get();
    }

    public List<String> getStreets(){
        // TODO retourner le nom des rue des villes gérées ou habitent des gens (pas de doublon)
        // attention, plusieurs habitant sont dans la même rue
        return villes.stream()
                .flatMap(ville -> ville.getHabitants()
                        .stream()
                        .map(habitant -> habitant.getRue())
                )
                .distinct()
                .collect(Collectors.toList());
    }

    public void taxe(char begin){
        // TODO faire en sorte que tous les habitants des villes gérées dont le nom commence
        // par la lettre en param payent leur taxe.
        villes.stream()
                .flatMap(ville -> ville.getHabitants()
                        .stream())
                .filter(habitant -> habitant.getNom().startsWith(Character.toString(begin))).forEach(habitant -> habitant.payerTaxe(600));
    }
}