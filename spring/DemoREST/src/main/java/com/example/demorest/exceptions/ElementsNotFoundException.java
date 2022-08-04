package com.example.demorest.exceptions;

import java.util.Set;

public class ElementsNotFoundException extends RuntimeException {
    private final Class<?> clazz;
    private final Set<Long> ids;

    public ElementsNotFoundException(Class<?> clazz, Set<Long> ids) {
        super("Cannot find entity {"+clazz.getSimpleName()+"} for ids: {"+ ids +"}");
        this.clazz = clazz;
        this.ids = ids;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public Set<Long> getIds() {
        return ids;
    }
}
