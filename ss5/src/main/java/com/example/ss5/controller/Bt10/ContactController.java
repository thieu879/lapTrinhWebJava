package com.example.ss5.controller.Bt10;
import com.example.ss5.model.Contact;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/contacts")
public class ContactController extends HttpServlet {
    private List<Contact> contacts;
    private int idCounter = 1;

    public void init() {
        contacts = new ArrayList<>();
        contacts.add(new Contact(idCounter++, "Nguyen", "An", "an@example.com", "0123456789"));
        getServletContext().setAttribute("contacts", contacts);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                req.getRequestDispatcher("/view/bt10/contact-form.jsp").forward(req, resp);
                break;
            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                for (Contact c : contacts) {
                    if (c.getId() == id) {
                        req.setAttribute("contact", c);
                        break;
                    }
                }
                req.getRequestDispatcher("/view/bt10/contact-form.jsp").forward(req, resp);
                break;
            default:
                req.setAttribute("contacts", contacts);
                req.getRequestDispatcher("/view/bt10/contact-list.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "create":
                contacts.add(new Contact(
                        idCounter++,
                        req.getParameter("firstName"),
                        req.getParameter("lastName"),
                        req.getParameter("email"),
                        req.getParameter("phone")
                ));
                break;
            case "update":
                int id = Integer.parseInt(req.getParameter("id"));
                for (Contact c : contacts) {
                    if (c.getId() == id) {
                        c.setFirstName(req.getParameter("firstName"));
                        c.setLastName(req.getParameter("lastName"));
                        c.setEmail(req.getParameter("email"));
                        c.setPhone(req.getParameter("phone"));
                        break;
                    }
                }
                break;
            case "delete":
                id = Integer.parseInt(req.getParameter("id"));
                contacts.removeIf(c -> c.getId() == id);
                break;
        }

        resp.sendRedirect("contacts");
    }
}
