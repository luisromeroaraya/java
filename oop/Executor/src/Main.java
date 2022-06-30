import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
//        https://www.baeldung.com/java-util-concurrent
//        1. Créez un ExecutorService de 3 Thread;
//        2. Demander à l'ExecutorService de realiser 6x l'opération suivante: (Callable)
//          - générer un mot de 2 à 6 lettre minuscules aléatoires.
//        3. (Attendre les résultats)
//        4. Une fois les 6 mots générés formez une phrase avec ces mots et ecrivez la en console.
//
//        Résultat possible:
//        azda danoah zd acdc tterss op

public class Main {
    public static void main(String[] args) {
        // create an ExecutorService of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // create a Callable that returns a random string between 2 and 6 characters
        Callable<String> callable = () -> {
            Random random = new Random();
            int length = random.nextInt(2,7);
            StringBuilder string = new StringBuilder();
            for (int i=0; i<length; i++) {
                string.append((char) random.nextInt(97,122));
            }
            return string.toString();
        };

        // do 6 times the Callable function randomString
        List<Future> futures = new ArrayList<>();
        for (int i=0; i < 6; i++) {
            futures.add(executor.submit(callable));
        }

        // tell the executor to stop waiting for submits or else the program won't stop
        executor.shutdown();

        // create a phrase with the 6 randomString
        StringBuilder phrase = new StringBuilder();
        for (Future future: futures) {
            try {
                phrase.append(future.get()).append(" ");
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error.");
            }
        }
        System.out.println(phrase.toString());
    }
}
