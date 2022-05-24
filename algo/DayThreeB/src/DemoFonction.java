public class DemoFonction {
    public static void main(String[] args) {
        String name = "Jules";
        direBonjour(name);

        int[] tab = new int[] {1, 2, 3};
        addFromTab(tab);
        for (int elem : tab) {
            System.out.println(elem);
        }

        int result = multiplierPar2(5);
        System.out.println(result);

        System.out.println(mult(1, 2));
    }
    // Procédure
    public static void direBonjour(String nom) {
        System.out.println("Bonjour " + nom);
    }

    public static void addFromTab(int[] tab) {
        int a = 2;
        tab[0] = 5;
    }

    // Fonction
    public static int multiplierPar2(int nbr) {
        return nbr * 2;
    }

    public static int mult(int nbr1, int nbr2) {
        return nbr1 * nbr2;
    }
}
