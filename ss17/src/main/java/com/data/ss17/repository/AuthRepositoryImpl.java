package com.data.ss17.repository;

import com.data.ss17.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

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
}
