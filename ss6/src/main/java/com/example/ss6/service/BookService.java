package com.example.ss6.service;

import com.example.ss6.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(String bookCode);
    List<Book> searchBooks(String searchTerm);
}
