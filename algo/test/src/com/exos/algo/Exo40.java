package com.exos.algo;

import java.util.*;

public class Exo40 {
    public static void main(String[] args) {
        ArrayList<String> guests = new ArrayList<>(Arrays.asList("James", "Abed", "Rufat"));
        System.out.println("This machine receives a list of guests and puts them in couples randomly.");
        System.out.println("Guests: " + guests);
        couple(guests);
    }

    public static void couple(ArrayList<String> guests) {
        ArrayList<String> give;
        ArrayList<String> receive;
        Map<String, String> couples = new HashMap<>();
        Random random = new Random();
        boolean error = true;
        int errors = 1;
        while(error) {
            give = new ArrayList<>(guests);
            receive = new ArrayList<>(guests);
            couples = new HashMap<>();
            error = false;
            int i = 0;
            while(i<give.size() && !error) {
                int index = random.nextInt(receive.size());
                String nameGive = give.get(i);
                String nameReceive = receive.get(index);
                while((nameGive.equals(nameReceive)) && (!error)) {
                    if ((receive.size() == 1)) {
                        System.out.println("Error! Names will be shuffled again.");
                        error = true;
                        errors++;
                    }
                    else {
                        index = random.nextInt(receive.size());
                        nameReceive = receive.get(index);
                    }
                }
                if (!error) {
                    receive.remove(index);
                    couples.put(give.get(i), nameReceive);
                    i++;
                }
            }
        }
        for (Map.Entry<String, String> entry : couples.entrySet()) {
            System.out.printf("%s gives a gift to %s.", entry.getKey(), entry.getValue());
            System.out.println("");
        }
        System.out.printf("Names were shuffled %s time(s).", errors);
    }
}
