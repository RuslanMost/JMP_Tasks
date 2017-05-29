package com.dabuita.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, Id extends Serializable> {
    public void persist(T entity);

    public T update(T entity);

    public T find(Id id);

    public void delete(T entity);

    public List<T> findAll();

    public void deleteAll();
}
