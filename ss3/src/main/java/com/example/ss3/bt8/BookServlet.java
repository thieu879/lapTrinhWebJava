package com.example.ss3.bt8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {

    public void init() {
        List<Book> bookList = new ArrayList<>();
        getServletContext().setAttribute("books", bookList);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String keyword = request.getParameter("search");
        List<Book> bookList = (List<Book>) getServletContext().getAttribute("books");

        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (keyword == null || keyword.isEmpty() ||
                    book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                filteredBooks.add(book);
            }
        }

        request.setAttribute("filteredBooks", filteredBooks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Bt/Bt8/home.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int year = Integer.parseInt(request.getParameter("year"));

        List<Book> bookList = (List<Book>) getServletContext().getAttribute("books");

        Book newBook = new Book(title, author, year);
        bookList.add(newBook);

        response.sendRedirect("BookServlet");
    }

    public void destroy() {

    }
}
