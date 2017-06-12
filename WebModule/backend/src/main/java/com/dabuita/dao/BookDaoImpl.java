package com.dabuita.dao;

import com.dabuita.models.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @PersistenceContext
    private EntityManager entityManager;

    public BookDaoImpl() {
    }

    public void persist(Book entity) {
        entityManager.persist(entity);
    }

    public Book update(Book entity) {
        return entityManager.merge(entity);
    }

    public Book find(String id) {
        Query query = entityManager.createNamedQuery("find book by id");
        query.setParameter("id", id);
        return (Book) query.getSingleResult();
    }

    public void delete(Book entity) {
        entityManager.remove(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Book> findAll() {
        return entityManager.createQuery("from Book").getResultList();
    }

    public void deleteAll() {
        List<Book> entityList = findAll();
        for (Book entity : entityList) {
            delete(entity);
        }
    }
}