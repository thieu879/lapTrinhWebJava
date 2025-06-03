package com.data.ss18.repository;

import com.data.ss18.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> getAllOrders(int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        Query<Order> query = session.createQuery("FROM Order o ORDER BY o.orderDate DESC", Order.class);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List<Order> searchOrders(String recipientName, Date startDate, Date endDate, String status, int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder hql = new StringBuilder("FROM Order o WHERE 1=1");
        if (recipientName != null && !recipientName.isEmpty())
            hql.append(" AND o.recipientName LIKE :recipientName");
        if (startDate != null)
            hql.append(" AND o.orderDate >= :startDate");
        if (endDate != null)
            hql.append(" AND o.orderDate <= :endDate");
        if (status != null && !status.isEmpty())
            hql.append(" AND o.status = :status");
        hql.append(" ORDER BY o.orderDate DESC");

        Query<Order> query = session.createQuery(hql.toString(), Order.class);

        if (recipientName != null && !recipientName.isEmpty())
            query.setParameter("recipientName", "%" + recipientName + "%");
        if (startDate != null)
            query.setParameter("startDate", startDate);
        if (endDate != null)
            query.setParameter("endDate", endDate);
        if (status != null && !status.isEmpty())
            query.setParameter("status", status);

        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public void updateOrderStatus(int orderId, String status) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, orderId);
        if (order != null) {
            order.setStatus(status);
            session.update(order);
        }
    }

    @Override
    public long countOrders() {
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.createQuery("SELECT COUNT(o) FROM Order o").uniqueResult();
    }

    @Override
    public long countSearchResults(String recipientName, Date startDate, Date endDate, String status) {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder hql = new StringBuilder("SELECT COUNT(o) FROM Order o WHERE 1=1");
        if (recipientName != null && !recipientName.isEmpty())
            hql.append(" AND o.recipientName LIKE :recipientName");
        if (startDate != null)
            hql.append(" AND o.orderDate >= :startDate");
        if (endDate != null)
            hql.append(" AND o.orderDate <= :endDate");
        if (status != null && !status.isEmpty())
            hql.append(" AND o.status = :status");

        Query<Long> query = session.createQuery(hql.toString(), Long.class);

        if (recipientName != null && !recipientName.isEmpty())
            query.setParameter("recipientName", "%" + recipientName + "%");
        if (startDate != null)
            query.setParameter("startDate", startDate);
        if (endDate != null)
            query.setParameter("endDate", endDate);
        if (status != null && !status.isEmpty())
            query.setParameter("status", status);

        return query.uniqueResult();
    }

    @Override
    public Order getOrderById(int orderId) {
        return sessionFactory.getCurrentSession().get(Order.class, orderId);
    }
}
