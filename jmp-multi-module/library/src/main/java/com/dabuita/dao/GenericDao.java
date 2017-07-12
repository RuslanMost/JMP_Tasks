package com.dabuita.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, Id extends Serializable> {
    void persist(T entity);

    T update(T entity);

    T find(Id id);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();
}
