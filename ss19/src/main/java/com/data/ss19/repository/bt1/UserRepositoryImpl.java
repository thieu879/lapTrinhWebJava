package com.data.ss19.repository.bt1;

import com.data.ss19.entity.bt1.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.createQuery("FROM User WHERE username = :username", User.class)
                .setParameter("username", username)
                .uniqueResult();
        if (user != null) {
            return user;
        }else {
            throw new EntityNotFoundException("Không tìm thấy khách hàng với username: " + username);
        }
    }

    @Override
    public List<User> getAllCustomers(int pageNumber, int pageSize) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User", User.class);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<User> user = query.getResultList();
        return user;
    }

    @Override
    public long totalCustomersCount() {
        Session session = sessionFactory.openSession();
        try {
            Query<Long> countQuery = session.createQuery("SELECT COUNT(c) FROM User c", Long.class);
            return countQuery.uniqueResult();
        } finally {
            session.close();
        }
    }
    @Override
    public void updateStatus(int id, boolean status) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        if (user != null) {
            user.setActive(status);
            session.update(user);
        }
    }

    @Override
    public void updateCustomer(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public User getCustomerById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }
    @Override
    public List<User> searchCustomers(String keyword, int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM User WHERE username LIKE :kw OR email LIKE :kw OR phoneNumber LIKE :kw";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("kw", "%" + keyword + "%");
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    @Override
    public long countSearchCustomers(String keyword) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT COUNT(c) FROM User c WHERE username LIKE :kw OR email LIKE :kw OR phoneNumber LIKE :kw";
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("kw", "%" + keyword + "%");
        return query.uniqueResult();
    }
}

