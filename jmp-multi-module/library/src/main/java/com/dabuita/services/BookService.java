package com.dabuita.services;

import com.dabuita.dao.BookDao;
import com.dabuita.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    @Transactional
    public void persist(Book entity) {
        bookDao.persist(entity);
    }

    @Transactional
    public void update(Book entity) {
        bookDao.update(entity);
    }

    public Book findById(String id) {
        Book book = bookDao.find(id);
        return book;
    }

    @Transactional
    public void delete(String id) {
        Book book = bookDao.find(id);
        bookDao.delete(book);
    }

    public List<Book> findAll() {
        List<Book> books = bookDao.findAll();
        return books;
    }

    @Transactional
    public void deleteAll() {
        bookDao.deleteAll();
    }
}
