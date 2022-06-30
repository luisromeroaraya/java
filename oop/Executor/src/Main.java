import java.util.Random;
import java.util.concurrent.*;

//        1. Créez un ExecutorService de 3 Thread;
//        2. Demander à l'ExecutorService de realiser 6x l'opération suivante: (Callable)
//          - générer un mot de 2 à 6 lettre minuscules aléatoires.
//        3. (Attendre les résultats)
//        4. Une fois les 6 mots générés formez une phrase avec ces mots et ecrivez la en console.
//
//
//        Résultat possible:
//        azda danoah zd acdc tterss op

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        // create an ExecutorService of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // do 6 times the Callable function randomString
        Future<String> future1 = executor.submit(() -> {
            return randomString(random.nextInt(2,6));
        });
        Future<String> future2 = executor.submit(() -> {
            return randomString(random.nextInt(2,6));
        });
        Future<String> future3 = executor.submit(() -> {
            return randomString(random.nextInt(2,6));
        });
        Future<String> future4 = executor.submit(() -> {
            return randomString(random.nextInt(2,6));
        });
        Future<String> future5 = executor.submit(() -> {
            return randomString(random.nextInt(2,6));
        });
        Future<String> future6 = executor.submit(() -> {
            return randomString(random.nextInt(2,6));
        });

        // create a phrase with the 6 randomString
        try {
            System.out.printf("%s %s %s %s %s %s", future1.get(), future2.get(), future3.get(), future4.get(), future5.get(), future6.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error.");
        }
    }
    public static String randomString(int length) {
        Random random = new Random();
        String string = "";
        for (int i=0; i<length; i++) {
            string = string + (char) random.nextInt(97,122);
        }
        return string;
    }
}
