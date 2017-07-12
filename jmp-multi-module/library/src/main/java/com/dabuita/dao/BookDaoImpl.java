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

    public void persist(final Book entity) {
        entityManager.persist(entity);
    }

    public Book update(final Book entity) {
        return entityManager.merge(entity);
    }

    public Book find(final String id) {
        Query query = entityManager.createNamedQuery("find book by id");
        query.setParameter("id", id);
        return (Book) query.getSingleResult();
    }

    public void delete(final Book entity) {
        entityManager.remove(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Book> findAll() {
        return entityManager.createQuery("from Book").getResultList();
    }

    public void deleteAll() {
        final List<Book> entityList = findAll();
        for (Book entity : entityList) {
            delete(entity);
        }
    }
}
