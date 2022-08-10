package com.example.demorest.exceptions;

public class NullElementException extends IllegalArgumentException {
    public final Class<?> clazz;

    public NullElementException(Class<?> clazz) {
        super("{" + clazz.getSimpleName() + "} can't be null.");
        this.clazz = clazz;
    }
}
