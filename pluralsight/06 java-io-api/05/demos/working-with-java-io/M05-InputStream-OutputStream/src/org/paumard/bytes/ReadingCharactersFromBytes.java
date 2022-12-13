package org.paumard.bytes;

import java.io.*;

public class ReadingCharactersFromBytes {

    public static void main(String[] args) {

        String hello = "Hello world!";

        ByteArrayOutputStream buffer = null;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             OutputStreamWriter writer = new OutputStreamWriter(bos);) {

            writer.write(hello);
            buffer = bos;

        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] bytes = buffer.toByteArray();

        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             InputStreamReader isr = new InputStreamReader(bis);
             BufferedReader reader = new BufferedReader(isr);) {

            String s = reader.readLine();
            System.out.println("s = " + s);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
