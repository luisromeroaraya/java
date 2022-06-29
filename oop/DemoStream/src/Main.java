import Models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // https://www.jmdoudoux.fr/java/dej/chap-streams.htm

        List<Person> list = new ArrayList<>();
        list.add(new Person("Will", 47));
        list.add(new Person("Brad", 17));
        list.add(new Person("Johnny", 67));
        list.add(new Person("Justin", 30));

        // How to use Stream:
        // 1. We declare intermediary operations
        // 2. At the end we call a terminal operation
        // (If we don't have a terminal operation the intermediary operations don't get executed)

        System.out.println("1. Simple Stream usage: Using chained operations over one stream to filter Person > 40:");
        list
                .stream() // Stream<Person>
                .filter(person -> person.getAge() >= 40) // Stream<Person>
                .map(Person::getName) // person -> string  Stream<String>
                // .forEach(person -> System.out.println(person));
                .forEach(System.out::println); // terminal operation

        // It is better to write all the operations together because you can't use the same stream again, let's try:
        System.out.println("------------------------------------------");
        System.out.println("2. Trying to use the same stream twice. Don't do it!");
        try {
            Stream<Person> stream = list.stream();
            stream.filter(person -> person.getAge() >= 40);
            stream.map(person -> person.getName());
        }
        catch (IllegalStateException exception) {
            System.out.println("You can't make 2 operations over the same Stream");
        }

        // Instead you have to create new streams to be able to join them
        System.out.println("------------------------------------------");
        System.out.println("Same exercise but using multiple streams (just to understand how it works):");
        Stream<Person> stream = list.stream();
        stream = stream.filter(person -> person.getAge() >= 40); // stream is used for a first time
        Stream<String> streamString = stream.map(Person::getName); //  a new stream is created
        streamString.forEach(System.out::println); // new stream is used now

        // Order of execution. If you change the order, the final result can change
        System.out.println("------------------------------------------");
        System.out.println("3. Printing a message at every step to see the order of execution:");
        list
                .stream()
                .filter(person -> {
                    System.out.println("intermediary operation / filter over " + person.getName());
                    return person.getAge() >= 40;
                })
                .map(person -> {
                    System.out.println("intermediary operation / map over " + person.getName());
                    return person.getName();
                })
                .forEach(person -> {
                    System.out.println("terminal operation / print over "+ person);
                });

        System.out.println("4. Les opérations intermédiaires");

        list.stream()
                // elimine des éléments de la stream - les opérations suivantes ne seront pas executées sur un rejeté
                .filter( p -> p.getName().length() <= 50 )
                // permet de transformer un élément en autre chose de n'imp. quel type T, renvoi un Stream<T>
                .map( p -> p.getName() + '-'+ p.getAge() )
                // mapToXXX permet de transformer 1 élément en un autre de type primitif. Renvoi un XXXStream (mapToInt renvoi un IntSteam)
                // Les Stream spécialisés dans la gestion des primitifs possèdes des méthodes adaptées
                //                .mapToInt( Personne::getAge )
                //-----
                // rejete les éléments en duplicata (comparaison d'adresse)
                .distinct()
                // Fait qq chose avec chaque element - forEach mais en intermédiaire
                .peek( System.out::println )
                // rejete les X premiers elements
                .skip(1)
                // s'arrete au X premiers elements non rejeté
                .limit(1)
                // tranformer 1 éléments en PLUSIEURS éléments de n'importe quel type T. Produit un Stream<T>
                // Il existe aussi un variance flatMapToXXX transformant en plusieurs élément de type primitif. Renvoi un XXXStream(flatMapToDouble renvoi un DoubleStream)
                .flatMap( nom -> Stream.of( new Person(nom, 10), new Person(nom, 10) ))
                // trie les éléments dans un ordre croissant (considéré comme inférieur -> supérieur) sont un facon de comparer renseigné
                // Je peux utiliser la surcharge sans param si les éléments comparés implementent l'interface Comparable
                .sorted( (p1, p2) -> p1.getAge() - p2.getAge() );

        System.out.println();


        System.out.println("5. Opérations terminales");

        // forEach applique un Consumer sur chaque élément
        list.stream()
                .forEach( System.out::println );

        // regroupe les éléments dans un tableau d'Object (surcharge permet de donner le type)
        Object[] tab =  list.stream()
                .toArray();

        // Compte le nombre d'éléments
        long numberPersOver40 = list.stream()
                .filter( p -> p.getAge() >= 40 )
                .count();

        // Verifie si au moins un élément est conforme au Predicate
        boolean presentOver40 = list.stream() // true
                .anyMatch( p -> p.getAge() > 40 );
        // Verifie si tous les éléments sont conforme au Predicate
        boolean everyOver40 = list.stream() // false
                .allMatch( p -> p.getAge() > 40 );
        // Verifie si aucun élément n'est conforme au Predicate
        boolean noneOver40 = list.stream() // false
                .noneMatch( p -> p.getAge() > 40 );
        // si le noneMatch renvoi false, le anyMatch renvoi true (si le Predicate est le même)

        // PErmet de recupérer n'importe quel élément (TRES souvent le premier)
        Optional<Person> anyPerson = list.stream().findAny();
        // Trouve TOUJOURS la première personne (sauf si vide)
        Optional<Person> firstPerson = list.stream().findFirst();
        // ATTENTION OPTIONAL

        // rassemble en une list
        List<Person> plusDe20Ans = list.stream()
                .filter( p -> p.getAge() >= 20)
                .collect( Collectors.toList() );

        System.out.println();
        System.out.println("5b. Demo Optional");

//        Person person = anyPerson.orElse( dominique );
//        Person person = anyPerson.orElseGet( () -> new Person("Person instantiated only if null", 0) ); //nouvelle personne

//        Person person = anyPerson.get(); // soit recupère la valeur soit lance une exception NoSuchElementException
//        Person person = anyPerson.orElseThrow(); // pareil que get()
        Person person = anyPerson.orElseThrow( () -> new RuntimeException("L'élément n'a pas été trouvé") ); // Pareil que get sauf qu'on choisi l'exception
        System.out.println(person);
        
        // BONUS
//        personnes.stream()
//                // produit un Stream<String>
//                .flatMap(personne -> Arrays.stream( personne.getNom().split("") ))
//                .forEach(System.out::println);

//        personnes.stream()
//        // produit un Stream<Character>
//        .flatMap(
//                personne -> {
//                    char[] tab = personne.getNom().toCharArray();
//                    // la ligne suivante tranforme mon tableau en un Stream de char
//                    return CharBuffer.wrap(tab).chars().mapToObj(ch -> (char)ch);
//                }
//        ).forEach(System.out::println);

//        personnes.stream()
//                // L'interface Comparator possède un certain nombre de méthodes static
//                // utiles dans le cadre des comparaison
//                .sorted(Comparator.comparingInt( Personne::getAge ).reversed())
//                .forEach(System.out::println);
    }
}