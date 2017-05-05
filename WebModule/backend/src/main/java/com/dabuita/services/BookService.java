package com.dabuita.services;

import com.dabuita.dao.BookDaoDefault;
import com.dabuita.models.Book;

import java.util.List;

public class BookService {

    private static BookDaoDefault bookDaoDefault;

    public BookService() {
        bookDaoDefault = new BookDaoDefault();
    }

    public void persist(Book entity) {
        bookDaoDefault.openCurrentSessionwithTransaction();
        bookDaoDefault.persist(entity);
        bookDaoDefault.closeCurrentSessionwithTransaction();
    }

    public void update(Book entity) {
        bookDaoDefault.openCurrentSessionwithTransaction();
        bookDaoDefault.update(entity);
        bookDaoDefault.closeCurrentSessionwithTransaction();
    }

    public Book findById(String id) {
        bookDaoDefault.openCurrentSession();
        Book book = bookDaoDefault.findById(id);
        bookDaoDefault.closeCurrentSession();
        return book;
    }

    public void delete(String id) {
        bookDaoDefault.openCurrentSessionwithTransaction();
        Book book = bookDaoDefault.findById(id);
        bookDaoDefault.delete(book);
        bookDaoDefault.closeCurrentSessionwithTransaction();
    }

    public List<Book> findAll() {
        bookDaoDefault.openCurrentSession();
        List<Book> books = bookDaoDefault.findAll();
        bookDaoDefault.closeCurrentSession();
        return books;
    }

    public void deleteAll() {
        bookDaoDefault.openCurrentSessionwithTransaction();
        bookDaoDefault.deleteAll();
        bookDaoDefault.closeCurrentSessionwithTransaction();
    }

    public BookDaoDefault bookDao() {
        return bookDaoDefault;
    }
}
