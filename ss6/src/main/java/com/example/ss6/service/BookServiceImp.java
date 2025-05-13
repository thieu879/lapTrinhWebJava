package com.example.ss6.service;

import com.example.ss6.dao.BookDao;
import com.example.ss6.dao.BookDaoImp;
import com.example.ss6.model.Book;

import java.util.List;

public class BookServiceImp implements BookService {
    private final BookDao bookDao;

    public BookServiceImp() {
        bookDao = new BookDaoImp();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void deleteBook(String bookCode) {
        bookDao.deleteBook(bookCode);
    }

    @Override
    public List<Book> searchBooks(String searchTerm) {
        return bookDao.searchBooks(searchTerm);
    }
}
