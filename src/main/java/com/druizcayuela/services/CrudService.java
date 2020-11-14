package com.druizcayuela.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "memory"})
public interface CrudService<T> {

    T save(T object);
    T findAll();
}
