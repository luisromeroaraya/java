package be.bstorm.akimts.child;

import be.bstorm.akimts.demo.Personne;
import lombok.Builder;

//@Builder
public class Employe extends Personne {
    public Employe(String nom, String age) {
        super(nom, age);
    }
}
