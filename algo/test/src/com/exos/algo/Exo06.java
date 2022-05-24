package com.exos.algo;

public class Exo06 {
    public static void main(String[] args) {
        // Demo
        int age = 18;
        int taille = 190;
        boolean majeur = age >= 18;
        boolean grand = taille > 180;
        boolean grandEtMajeur = grand && majeur; // true if everything is true
        boolean grandOuMajeur = grand || majeur; // false if everything is false, true if anything is true
        boolean petit = !grand;
        boolean xor = grand ^ majeur; // ?
        System.out.println("Demo: Grand et Majeur = " + grandEtMajeur + ", Grand ou Majeur = " + grandOuMajeur + ", Grand^Majeur = " + xor);
        // Demo Conditions
        if (grandEtMajeur) {
            System.out.println("You can get in...");
        }
        else {
            System.out.println("You are not allowed to get in...");
        }

        switch (age) {
            case 18:
                System.out.println("You are exactly 18 years old.");
                break;
            default:
                System.out.println("You are "+ age + " years old.");
        }

        // Exercices
        int a = 3, b = 9, e = 9;
        boolean c = false, d = !c;
        boolean one = a > 8; // false
        boolean two = b == 9; // true
        boolean three = !(a != 3); // true
        boolean four = !c; // true
        boolean five = (a < b) || c; // true
        boolean six = !((a + b) != 12); // true
        boolean seven = (b == 5) || ((e > 10) && (a < 8)); // false
        boolean eight = ((((b==5) || ((e > 10) && (a < 8))) || (a < b) || c) && c); // false
        System.out.printf("Exercices: 1. %s, 2. %s, 3. %s, 4. %s, 5. %s, 6. %s, 7. %s; 8. %s", one, two, three, four, five, six, seven, eight);
    }
}
