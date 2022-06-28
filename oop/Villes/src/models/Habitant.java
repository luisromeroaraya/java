package models;

public class Habitant {
    private String nom;
    private String prenom;
    private String rue;
    private int numero;
    private double totalTaxes;

    // constructors
    public Habitant(String nom, String prenom, String rue, int numero) {
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.numero = numero;
    }

    // getters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getRue() {
        return rue;
    }

    public int getNumero() {
        return numero;
    }

    public double getTotalTaxes() {
        return totalTaxes;
    }

    // setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // methods
    public void payerTaxe(double montant){
        this.totalTaxes += montant;
    }
}