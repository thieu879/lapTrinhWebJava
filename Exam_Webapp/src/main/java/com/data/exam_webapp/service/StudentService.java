package com.data.exam_webapp.service;

import com.data.exam_webapp.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents(int page, int size);
    int getStudentCount();
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    List<Student> searchStudents(String keyword, int page, int size);
    int getSearchStudentCount(String keyword);
}
