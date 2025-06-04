package com.data.ss19.repository.bt3;

import com.data.ss19.entity.bt3.Theater;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class TheaterRepositoryImpl implements TheaterRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Theater> getAllTheaters(int page, int size) {
        String jpql = "SELECT t FROM Theater t";
        return entityManager.createQuery(jpql, Theater.class)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }

    @Override
    public int getCountTheaters() {
        String jpql = "SELECT COUNT(t) FROM Theater t";
        return ((Long) entityManager.createQuery(jpql).getSingleResult()).intValue();
    }

    @Override
    public Theater getTheaterById(long id) {
        return entityManager.find(Theater.class, id);
    }

    @Override
    public void saveTheater(Theater theater) {
        entityManager.persist(theater);
    }

    @Override
    public void deleteTheater(long id) {
        Theater theater = entityManager.find(Theater.class, id);
        if (theater != null) {
            entityManager.remove(theater);
        }
    }

    @Override
    public List<Theater> searchTheaters(String keyword, int page, int size) {
        String jpql = "SELECT t FROM Theater t WHERE t.theaterName LIKE :kw OR t.address LIKE :kw";
        return entityManager.createQuery(jpql, Theater.class)
                .setParameter("kw", "%" + keyword + "%")
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }

    @Override
    public int getCountSearchTheaters(String keyword) {
        String jpql = "SELECT COUNT(t) FROM Theater t WHERE t.theaterName LIKE :kw OR t.address LIKE :kw";
        return ((Long) entityManager.createQuery(jpql)
                .setParameter("kw", "%" + keyword + "%")
                .getSingleResult()).intValue();
    }

    @Override
    public void updateTheater(Theater theater) {
        entityManager.merge(theater);
    }
    @Override
    public Theater findById(Long id) {
        return sessionFactory.getCurrentSession().get(Theater.class, id);
    }
    @Override
    public List<Theater> findByStatus(Boolean status) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Theater WHERE status = :status ORDER BY id DESC", Theater.class)
                .setParameter("status", status)
                .getResultList();
    }

}
