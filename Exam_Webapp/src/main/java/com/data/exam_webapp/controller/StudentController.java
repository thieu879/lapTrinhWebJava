package com.data.exam_webapp.controller;

import com.data.exam_webapp.entity.Course;
import com.data.exam_webapp.entity.Student;
import com.data.exam_webapp.service.CourseService;
import com.data.exam_webapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/students")
    public String listStudents(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model
    ) {
        List<Student> students;
        int totalItems;

        if(!keyword.isEmpty()) {
            students = studentService.searchStudents(keyword, page, size);
            totalItems = studentService.getSearchStudentCount(keyword);
        } else {
            students = studentService.getStudents(page, size);
            totalItems = studentService.getStudentCount();
        }

        model.addAttribute("students", students);
        model.addAttribute("courses", courseService.getCourses(0, 100));
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", (int) Math.ceil((double) totalItems / size));

        return "list-students";
    }

    @GetMapping("/addStudent")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("allCourses", courseService.getCourses(0, 100));
        return "form-students";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(
            @Valid @ModelAttribute Student student,
            BindingResult result,
            @RequestParam(value = "courseIds", required = false) List<Long> courseIds,
            Model model
    ) {
        if(result.hasErrors()) {
            model.addAttribute("allCourses", courseService.getCourses(0, 100));
            return "form-students";
        }

        if (courseIds != null && !courseIds.isEmpty()) {
            Set<Course> selectedCourses = new HashSet<>(courseService.getCoursesByIds(courseIds));
            student.setCourses(selectedCourses);
        } else {
            student.setCourses(new HashSet<>());
        }

        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/editStudent/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("allCourses", courseService.getCourses(0, 100));
        return "form-students";
    }

    @PostMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}

