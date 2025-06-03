package com.data.ss17.repository;

import com.data.ss17.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getAllProducts(int page, int size) {
        Session session = sessionFactory.openSession();
        try {
            Query<Product> query = session.createQuery("FROM Product ORDER BY id", Product.class);
            query.setFirstResult((page - 1) * size); // Sửa công thức tính toán
            query.setMaxResults(size);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    @Override
    public long countTotalProducts() {
        Session session = sessionFactory.openSession();
        try {
            Query<Long> countQuery = session.createQuery("SELECT COUNT(p) FROM Product p", Long.class);
            return countQuery.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public Product getProductById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Product.class, id);
        } finally {
            session.close();
        }
    }
}

