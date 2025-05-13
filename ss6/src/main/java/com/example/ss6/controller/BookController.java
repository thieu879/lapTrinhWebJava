package com.example.ss6.controller;

import com.example.ss6.model.Book;
import com.example.ss6.service.BookService;
import com.example.ss6.service.BookServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookController", urlPatterns = "/books")
public class BookController extends HttpServlet {
    private final BookService bookService;

    public BookController() {
        bookService = new BookServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login");
            return;
        }

        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "add":
                req.getRequestDispatcher("/view/formAdd.jsp").forward(req, resp);
                break;
            case "edit":
                String bookCode = req.getParameter("bookCode");
                List<Book> books = bookService.searchBooks(bookCode);
                if (!books.isEmpty()) {
                    req.setAttribute("book", books.get(0));
                    req.getRequestDispatcher("/view/formEdit.jsp").forward(req, resp);
                } else {
                    resp.sendRedirect("/books");
                }
                break;
            case "list":
            default:
                String searchTerm = req.getParameter("searchTerm");
                if (searchTerm != null && !searchTerm.trim().isEmpty()) {
                    books = bookService.searchBooks(searchTerm);
                } else {
                    books = bookService.getAllBooks();
                }
                req.setAttribute("books", books);
                req.getRequestDispatcher("/view/listBook.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login");
            return;
        }

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                Book newBook = new Book();
                newBook.setBookCode(req.getParameter("bookCode"));
                newBook.setTitle(req.getParameter("title"));
                newBook.setAuthor(req.getParameter("author"));
                newBook.setCategory(req.getParameter("category"));
                newBook.setQuantity(Integer.parseInt(req.getParameter("quantity")));
                bookService.addBook(newBook);
                resp.sendRedirect("/books");
                break;
            case "update":
                Book updatedBook = new Book();
                updatedBook.setBookCode(req.getParameter("bookCode"));
                updatedBook.setTitle(req.getParameter("title"));
                updatedBook.setAuthor(req.getParameter("author"));
                updatedBook.setCategory(req.getParameter("category"));
                updatedBook.setQuantity(Integer.parseInt(req.getParameter("quantity")));
                bookService.updateBook(updatedBook);
                resp.sendRedirect("/books");
                break;
            case "delete":
                String bookCode = req.getParameter("bookCode");
                bookService.deleteBook(bookCode);
                resp.sendRedirect("/books");
                break;
            default:
                resp.sendRedirect("/books");
                break;
        }
    }
}