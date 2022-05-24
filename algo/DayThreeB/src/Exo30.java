import java.util.Scanner;

public class Exo30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] tab = new int[] {1, 2, 3, 5, 7, 0};
        System.out.println("Quel valeur voulez-vous insérer ?");
        int value = Integer.parseInt(sc.nextLine());

        int posValue = 0;
        for (int i = 0; i < tab.length - 1; i++) {
            if (tab[i] < value) {
                posValue++;
            }
        }

        for (int i = tab.length - 1; i > posValue; i--) {
            tab[i] = tab[i-1];
        }
        tab[posValue] = value;

        for (int elem : tab) {
            System.out.println(elem);
        }
    }
}
