package com.data.ss19.controller.bt3;

import com.data.ss19.entity.bt3.Theater;
import com.data.ss19.service.bt3.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TheaterController {
    private final TheaterService theaterService;

    @Autowired
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping("/theaters")
    public String showTheaters(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String keyword,
            Model model) {
        List<Theater> theaters;
        int totalTheaters;
        if (keyword != null && !keyword.isEmpty()) {
            theaters = theaterService.searchTheaters(keyword, page, size);
            totalTheaters = theaterService.getCountSearchTheaters(keyword);
            model.addAttribute("keyword", keyword);
        } else {
            theaters = theaterService.getAllTheaters(page, size);
            totalTheaters = theaterService.getCountTheaters();
        }
        int totalPages = (int) Math.ceil((double) totalTheaters / size);
        model.addAttribute("theaters", theaters);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "/bt3/theater-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTheater(@PathVariable long id, RedirectAttributes redirectAttributes) {
        theaterService.deleteTheater(id);
        redirectAttributes.addFlashAttribute("message", "Đã xử lý xóa rạp thành công!");
        return "redirect:/theaters";
    }

    // Thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("theater", new Theater());
        return "/bt3/theater-form";
    }

    @PostMapping("/add")
    public String addTheater(@ModelAttribute("theater") Theater theater, RedirectAttributes redirectAttributes) {
        theaterService.saveTheater(theater);
        redirectAttributes.addFlashAttribute("message", "Thêm rạp thành công!");
        return "redirect:/theaters";
    }

    // Sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Theater theater = theaterService.getTheaterById(id);
        model.addAttribute("theater", theater);
        return "/bt3/theater-form";
    }

    @PostMapping("/edit")
    public String updateTheater(@ModelAttribute("theater") Theater theater, RedirectAttributes redirectAttributes) {
        theaterService.updateTheater(theater);
        redirectAttributes.addFlashAttribute("message", "Cập nhật rạp thành công!");
        return "redirect:/theaters";
    }
}
