public class Exo32 {
    public static void main(String[] args) {
        int[] tab1 = new int[]{4, 8};
        int[] tab2 = new int[]{5, 2, 9, 4};
        int[] tab3 = new int[tab1.length + tab2.length];

        boolean fromTab2 = false;

        for (int i = 0; i < tab3.length; i++) {
            // On trouve le minimum des tableaux
            int minimum = Integer.MAX_VALUE;
            int posMin = -1;
            for (int j = 0; j < tab1.length; j++) {
                if (minimum > tab1[j] && tab1[j] != -1) {
                    minimum = tab1[j];
                    posMin = j;
                    fromTab2 = false;
                }
            }

            for (int k = 0; k < tab2.length; k++) {
                if (minimum > tab2[k] && tab2[k] != -1) {
                    minimum = tab2[k];
                    posMin = k;
                    fromTab2 = true;
                }
            }

            if (fromTab2) {
                tab2[posMin] = -1;
            } else {
                tab1[posMin] = -1;
            }

            tab3[i] = minimum;

        }

        for (int elem : tab3) {
            System.out.println(elem);
        }
    }
}
