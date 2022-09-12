package com.exceptions.m3.questions;

import java.io.BufferedReader;
import java.io.FileReader;

public class QuestionOne {

    // does not compile - an unhandled exception thrown by close() - we must wrap into another try/catch
    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("file.txt"));
        } catch (Exception ex) {

        } finally {
//            br.close();
        }
    }
}
