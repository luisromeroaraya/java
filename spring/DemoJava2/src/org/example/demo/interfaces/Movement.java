package org.example.demo.interfaces;

@FunctionalInterface // a functional interface can only have 1 method
public interface Movement<T> {
    void move(T vehicle);
}
