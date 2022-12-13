package org.paumard.bytes;

import org.paumard.bytes.model.User;

import java.io.*;

public class PlayWithObjectStream {

    public static void main(String[] args) {

        User u1 = new User("Paul", 23);
        User u2 = new User("Jennifer", 25);

        try (FileOutputStream fos = new FileOutputStream("files/users.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {

            oos.writeObject(u1);
            oos.writeObject(u2);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("files/users.bin");
             ObjectInputStream ois = new ObjectInputStream(fis);) {

            User paul = (User)ois.readObject();
            User jennifer = (User)ois.readObject();

            System.out.println("jennifer = " + jennifer);
            System.out.println("paul = " + paul);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
