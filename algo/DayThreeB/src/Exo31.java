import java.util.Arrays;
import java.util.Scanner;

public class Exo31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] tab = new int[] {1, 2, 3, 5, 5};

        System.out.println("Quelle valeur cherchez-vous ?");
        int value = Integer.parseInt(sc.nextLine());

        int[] position = new int[tab.length];
        Arrays.fill(position, -1);
        int nbrPosition = 0;
        boolean found = false;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == value) {
                position[nbrPosition] = i;
                nbrPosition++;
            }
        }

        for (int i = 0; i < nbrPosition; i++) {
            System.out.println(position[i]);
        }
    }
}
