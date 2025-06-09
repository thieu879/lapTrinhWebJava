package com.data.exam_webapp.service;

import com.data.exam_webapp.entity.Student;
import com.data.exam_webapp.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> getStudents(int page, int size) {
        return studentRepository.getStudents(page, size);
    }

    @Override
    public int getStudentCount() {
        return studentRepository.getStudentCount();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.saveStudent(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }

    @Override
    public List<Student> searchStudents(String keyword, int page, int size) {
        return studentRepository.searchStudents(keyword, page, size);
    }

    @Override
    public int getSearchStudentCount(String keyword) {
        return studentRepository.getSearchStudentCount(keyword);
    }
}
