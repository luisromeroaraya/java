package com.exceptions.m5.overriding;

import java.io.IOException;

public class OverridingExample {

    public static void main(String[] args) {

        TeamMember tm = new Developer();

        try {
            tm.work();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
