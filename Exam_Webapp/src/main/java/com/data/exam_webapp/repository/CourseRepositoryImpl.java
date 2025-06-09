package com.data.exam_webapp.repository;

import com.data.exam_webapp.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Course> getCourses(int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Course", Course.class)
                .setFirstResult(page * size)
                .setMaxResults(size)
                .getResultList();
    }

    @Override
    public int getCourseCount() {
        Session session = sessionFactory.getCurrentSession();
        return ((Long) session.createQuery("SELECT COUNT(*) FROM Course").uniqueResult()).intValue();
    }

    @Override
    public Course getCourseById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }

    @Override
    public Course saveCourse(Course course) {
        Session session = sessionFactory.getCurrentSession();
        if (course.getId() == null) {
            session.persist(course);
        } else {
            session.merge(course);
        }
        return course;
    }

    @Override
    public void deleteCourse(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Course course = session.get(Course.class, id);
        if (course != null) {
            session.remove(course);
        }
    }
    @Override
    public List<Course> getCoursesByIds(List<Long> ids) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Course WHERE id IN :ids", Course.class)
                .setParameter("ids", ids)
                .getResultList();
    }

}
