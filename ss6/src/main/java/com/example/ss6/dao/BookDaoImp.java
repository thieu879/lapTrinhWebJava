package com.example.ss6.dao;

import com.example.ss6.model.Book;
import com.example.ss6.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImp implements BookDao {
    @Override
    public List<Book> getAllBooks() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Book> books = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_all_books()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Book book = new Book(
                        rs.getString("bookCode"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("category"),
                        rs.getInt("quantity")
                );
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return books;
    }

    @Override
    public void addBook(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_book(?,?,?,?,?)}");
            callSt.setString(1, book.getBookCode());
            callSt.setString(2, book.getTitle());
            callSt.setString(3, book.getAuthor());
            callSt.setString(4, book.getCategory());
            callSt.setInt(5, book.getQuantity());
            callSt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public void updateBook(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_book(?,?,?,?,?)}");
            callSt.setString(1, book.getBookCode());
            callSt.setString(2, book.getTitle());
            callSt.setString(3, book.getAuthor());
            callSt.setString(4, book.getCategory());
            callSt.setInt(5, book.getQuantity());
            callSt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public void deleteBook(String bookCode) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_book(?)}");
            callSt.setString(1, bookCode);
            callSt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public List<Book> searchBooks(String searchTerm) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Book> books = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call search_books(?)}");
            callSt.setString(1, searchTerm);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Book book = new Book(
                        rs.getString("bookCode"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("category"),
                        rs.getInt("quantity")
                );
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return books;
    }
}