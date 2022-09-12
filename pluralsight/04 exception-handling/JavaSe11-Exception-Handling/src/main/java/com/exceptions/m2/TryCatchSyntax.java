package com.exceptions.m2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryCatchSyntax {

    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("basic_try_demo.txt"));

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e) {
            System.err.format("FileNotFoundException: %s%n", e);
        }
        catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        finally {
            try {
                if(br != null) {
                    br.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
