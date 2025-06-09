package com.data.exam_webapp.service;

import com.data.exam_webapp.entity.Course;
import com.data.exam_webapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getCourses(int page, int size) {
        return courseRepository.getCourses(page, size);
    }

    @Override
    public int getCourseCount() {
        return courseRepository.getCourseCount();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.saveCourse(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteCourse(id);
    }

    @Override
    public List<Course> getCoursesByIds(List<Long> ids) {
        return courseRepository.getCoursesByIds(ids);
    }
}
