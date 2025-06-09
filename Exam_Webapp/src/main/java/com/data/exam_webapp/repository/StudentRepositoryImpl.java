package com.data.exam_webapp.repository;

import com.data.exam_webapp.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getStudents(int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Student", Student.class)
                .setFirstResult(page * size)
                .setMaxResults(size)
                .getResultList();
    }

    @Override
    public int getStudentCount() {
        Session session = sessionFactory.getCurrentSession();
        return ((Number) session.createQuery("SELECT COUNT(*) FROM Student")
                .getSingleResult()).intValue();
    }

    @Override
    public Student getStudentById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Override
    public Student saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        if (student.getAutoId() == null) {
            session.persist(student);
        } else {
            session.merge(student);
        }
        return student;
    }

    @Override
    public void deleteStudent(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        if (student != null) {
            session.remove(student);
        }
    }

    @Override
    public List<Student> searchStudents(String keyword, int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Student s WHERE " +
                "LOWER(s.name) LIKE :keyword OR " +
                "s.email LIKE :keyword OR " +
                "s.phone LIKE :keyword";
        return session.createQuery(hql, Student.class)
                .setParameter("keyword", "%" + keyword.toLowerCase() + "%")
                .setFirstResult(page * size)
                .setMaxResults(size)
                .getResultList();
    }

    @Override
    public int getSearchStudentCount(String keyword) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT COUNT(*) FROM Student s WHERE " +
                "LOWER(s.name) LIKE :keyword OR " +
                "s.email LIKE :keyword OR " +
                "s.phone LIKE :keyword";
        return ((Number) session.createQuery(hql)
                .setParameter("keyword", "%" + keyword.toLowerCase() + "%")
                .getSingleResult()).intValue();
    }
}

