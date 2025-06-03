package com.data.ss18.repository;

import com.data.ss18.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AuthRepositoryImpl implements AuthRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void register(String username, String password, String email, String phone) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = new Customer(username, password, email, phone, false, 2);
        session.save(customer);
    }
    @Override
    public void login(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.createQuery("FROM Customer WHERE username = :username AND password = :password", Customer.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .uniqueResult();
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.createQuery("FROM Customer WHERE username = :username", Customer.class)
                .setParameter("username", username)
                .uniqueResult();
        if (customer != null) {
            return customer;
        }else {
            throw new EntityNotFoundException("Không tìm thấy khách hàng với username: " + username);
        }
    }

    @Override
    public List<Customer> getAllCustomers(int pageNumber, int pageSize) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Customer", Customer.class);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public long totalCustomersCount() {
        Session session = sessionFactory.openSession();
        try {
            Query<Long> countQuery = session.createQuery("SELECT COUNT(c) FROM Customer c", Long.class);
            return countQuery.uniqueResult();
        } finally {
            session.close();
        }
    }
    @Override
    public void updateStatus(int id, int status) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, id);
        if (customer != null) {
            customer.setStatus(status);
            session.update(customer);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }
    @Override
    public List<Customer> searchCustomers(String keyword, int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Customer WHERE username LIKE :kw OR email LIKE :kw OR phone LIKE :kw";
        Query<Customer> query = session.createQuery(hql, Customer.class);
        query.setParameter("kw", "%" + keyword + "%");
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    @Override
    public long countSearchCustomers(String keyword) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT COUNT(c) FROM Customer c WHERE username LIKE :kw OR email LIKE :kw OR phone LIKE :kw";
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("kw", "%" + keyword + "%");
        return query.uniqueResult();
    }
}

