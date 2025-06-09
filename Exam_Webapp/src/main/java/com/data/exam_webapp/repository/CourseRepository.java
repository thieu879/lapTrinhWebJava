package com.data.exam_webapp.repository;

import com.data.exam_webapp.entity.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> getCourses(int page, int size);
    int getCourseCount();
    Course getCourseById(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCoursesByIds(List<Long> ids);
}
