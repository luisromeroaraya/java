package com.metaltravelguide.places.exceptions;

public class ElementNotFoundException extends RuntimeException {
    private final Class<?> clazz;
    private final Object id;

    public ElementNotFoundException(Class<?> clazz, Object id) {
        super("Cannot find entity {"+clazz.getSimpleName()+"} for id {"+ id +"}");
        this.clazz = clazz;
        this.id = id;
    }

    public ElementNotFoundException(String message, Class<?> clazz, Object forId) {
        super(message);
        this.clazz = clazz;
        this.id = forId;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public Object getForId() {
        return id;
    }
}
