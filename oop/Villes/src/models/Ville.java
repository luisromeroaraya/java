package models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Ville {
    private final int codePostal;
    private final String nom;
    private final Set<Habitant> habitants;
    private double montantTaxe;

    // constructors
    public Ville(int codePostal, String nom, Collection<Habitant> habitants, double montantTaxe) {
        this.codePostal = codePostal;
        this.nom = nom;
        this.habitants = new HashSet<>(habitants);
        this.montantTaxe = montantTaxe;
    }

    // getters
    public int getCodePostal() { return codePostal; }

    public String getNom() {
        return nom;
    }

    public double getMontantTaxe() { return montantTaxe; }

    public Set<Habitant> getHabitants() { return new HashSet<>(habitants); }

    // methods
    public void ajouter(Habitant habitant){
        this.habitants.add(habitant);
    }

    public void retirer(Habitant habitant){
        this.habitants.remove(habitant);
    }

    public void taxer(){
        this.habitants.forEach(h -> h.payerTaxe(montantTaxe));
    }
}