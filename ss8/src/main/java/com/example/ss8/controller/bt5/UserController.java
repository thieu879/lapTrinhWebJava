package com.example.ss8.controller.bt5;

import com.example.ss8.model.bt5.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/users")
    public ModelAndView showUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Nguyen Van A", 25, LocalDate.of(1999, 1, 1), "a@gmail.com", "0912345678"));
        userList.add(new User("Tran Thi B", 30, LocalDate.of(1994, 5, 10), "b@yahoo.com", "0987654321"));
        userList.add(new User("Le Van C", 22, LocalDate.of(2002, 9, 15), "c@outlook.com", "0909090909"));

        ModelAndView modelAndView = new ModelAndView("/bt5/userList");
        modelAndView.addObject("users", userList);
        return modelAndView;
    }
}
