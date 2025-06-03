package com.data.ss18.repository;

import com.data.ss18.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getAllProduct(int pageNumber, int pageSize) {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> query = session.createQuery("FROM Product", Product.class);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.list();
    }

    @Override
    public void saveProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public long totalProductCount() {
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.createQuery("SELECT COUNT(p) FROM Product p").uniqueResult();
    }

    @Override
    public void updateProduct(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    @Override
    public Product getProductById(int id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public List<Product> filterProducts(String keyword, int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Product p WHERE p.productName LIKE :kw OR p.description LIKE :kw";
        Query<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("kw", "%" + keyword + "%");
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public long countFilteredProducts(String keyword) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT COUNT(p) FROM Product p WHERE p.productName LIKE :kw OR p.description LIKE :kw";
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("kw", "%" + keyword + "%");
        return query.uniqueResult();
    }
}
