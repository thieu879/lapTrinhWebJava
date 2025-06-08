package com.data.ss20.repository;

import com.data.ss20.entity.Seed;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeedRepositoryImpl implements SeedRepository {
    private final SessionFactory sessionFactory;

    public SeedRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Seed> getSeeds() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Seed", Seed.class)
                .getResultList();
    }

    @Override
    public Seed getSeedById(Long id) {
        return sessionFactory.getCurrentSession().get(Seed.class, id);
    }

    @Override
    public void saveSeed(Seed seed) {
        sessionFactory.getCurrentSession().save(seed);
    }

    @Override
    public void updateSeed(Seed seed) {
        sessionFactory.getCurrentSession().update(seed);
    }

    @Override
    public void deleteSeed(Long id) {
        Seed seed = getSeedById(id);
        if (seed != null) {
            sessionFactory.getCurrentSession().delete(seed);
        }
    }

    @Override
    public List<Seed> searchSeeds(String keyword) {
        String hql = "FROM Seed WHERE seedName LIKE :kw OR description LIKE :kw";
        return sessionFactory.getCurrentSession()
                .createQuery(hql, Seed.class)
                .setParameter("kw", "%" + keyword + "%")
                .getResultList();
    }
}

