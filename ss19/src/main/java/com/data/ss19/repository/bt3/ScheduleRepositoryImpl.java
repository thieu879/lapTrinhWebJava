package com.data.ss19.repository.bt3;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean existsByTheaterId(long theaterId) {
        String jpql = "SELECT COUNT(s) FROM Schedule s WHERE s.theater.id = :theaterId";
        Long count = entityManager.createQuery(jpql, Long.class)
                .setParameter("theaterId", theaterId)
                .getSingleResult();
        return count > 0;
    }
}
