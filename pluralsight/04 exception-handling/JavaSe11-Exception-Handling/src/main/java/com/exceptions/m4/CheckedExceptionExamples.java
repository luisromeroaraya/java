package com.exceptions.m4;

import java.io.*;

public class CheckedExceptionExamples {

    public static void main(String[] args) {

        try (var in = new FileInputStream("file.txt")){
        } catch(IOException e){

        }

        try {
            var br = new BufferedReader(new FileReader("file.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
