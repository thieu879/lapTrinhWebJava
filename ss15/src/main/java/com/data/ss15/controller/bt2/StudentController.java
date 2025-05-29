package com.data.ss15.controller.bt2;

import com.data.ss15.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    private List<Student> students = new ArrayList<>();
    public StudentController(){
        Student student1 = new Student("SV001", "Nguyen Van A", 20, "CTK42", "a@example.com", "Hanoi", "0123456789");
        Student student2 = new Student("SV002", "Tran Thi B", 21, "CTK42", "b@example.com", "HCM", "0987654321");

        students.add(student1);
        students.add(student2);
    }
    @GetMapping("/students")
    public String getStudentList(Model model){
        model.addAttribute("students", students);
        return "bt2/studentList";
    }

}
