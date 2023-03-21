package com.training.dao;

import com.training.model.Entity;

import java.util.List;

public abstract class AbstractDAO<K, T extends Entity> {
    public abstract List<T> getAll();

    public abstract T getById(K id);

    public abstract void add(T t);

    public T getByLogin(String login){
        throw new UnsupportedOperationException();
    }
}
