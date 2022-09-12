package com.exceptions.m5;

public class ThrowingExceptions {

    public static void main(String[] args) {

        Person p = new Person();
        p.setAge(10);

        System.out.println(p.getAge());

        p.setAge1(10);

//        p.setAge2(10); // throws a checked exception

        increaseAge(p, 10);
    }

    static void increaseAge(Person p, int age) {
//        p.setAge2(age);
    }
}
