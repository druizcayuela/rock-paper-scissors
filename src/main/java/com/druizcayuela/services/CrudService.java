package com.druizcayuela.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * The Crud Service interface
 *
 * @author druizcayuela
 *
 */

@Service
@Profile({"default", "memory"})
public interface CrudService<T> {

    /**
     * Store a object
     *
     * @param object to be stored
     * @return the object which has been stored
     */
    T save(T object);

    /**
     * Find a kind of object
     *
     * @return the object
     */
    T findAll();
}
