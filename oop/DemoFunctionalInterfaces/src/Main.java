import Models.Personne;

import java.time.LocalDate;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        consumer = consumer.andThen( (chaine) -> System.out.println(chaine.toUpperCase()) );

        LocalDate ld = LocalDate.now();
        Supplier<LocalDate> supplier = LocalDate::now;
        String s = ( "MA CHAINE".concat( "ma chaine".toUpperCase() ) ).toLowerCase();
        s = "MA CHAINE";
        Function<String, String> function = s::concat;

        // toLowerCase : String -> String
        // toUpperCase : String -> String
        // concat      : String -> String

        // toUpperCase      =>    (concat)      =>   toLowerCase
        // String -> String----String -> String----String -> String

        function = function.compose( String::toUpperCase );
        function = function.andThen( String::toLowerCase );

        System.out.println( function.apply( "ma chaine" ) );
        // ma chaine   - avant toUpperCase
        // MA CHAINE   - apres toUpperCase
        // MA CHAINE   - avant concat
        // MA CHAINEMA CHAINE - apres concat
        // MA CHAINEMA CHAINE - avant toLowerCase
        // ma chainema chaine - après toLowerCase

        UnaryOperator<String> op = (chaine) -> {
            chaine = chaine.toUpperCase();
            chaine = "MA CHAINE".concat(chaine);
            return chaine.toLowerCase();
        };

        BiFunction<String, String, String> biFunc = String::concat;
        BinaryOperator<String> biOp = String::concat;

        Runnable run = () -> System.out.println("ok");

        BiFunction<String,Integer, Personne> biFunc2 = Personne::new;
        BiFunction<String,Integer, String> composition = biFunc2.andThen( Personne::getAge )
                .andThen( (entier) -> "Age de la personne: "+entier);

        String agePersonne = composition.apply("luc", 50);
        System.out.println( agePersonne );
    }
}
