package com.druizcayuela.services.memory;

/**
 * The Abstract Memory Service
 * I use this pattern because it's ideal if you want to have more than
 * one kind of services. Everything is wrapped and you just need to change the
 * profile for the new kind of Service.
 *
 * @author druizcayuela
 *
 */

public class AbstractMemoryService<T> {

    private T localMemory;

    public T save(T object) {

        if (object ==  null) {
            throw new RuntimeException("Object cannot be null");
        }

        localMemory = object;
        return object;
    }

    public T findObject() {
        return localMemory;
    }
}
