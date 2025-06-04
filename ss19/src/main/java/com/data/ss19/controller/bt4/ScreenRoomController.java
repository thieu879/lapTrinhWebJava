package com.data.ss19.controller.bt4;

import com.data.ss19.entity.bt3.Theater;
import com.data.ss19.entity.bt4.ScreenRoom;
import com.data.ss19.entity.bt4.Seat;
import com.data.ss19.repository.bt4.SeatRepository;
import com.data.ss19.service.bt3.TheaterService;
import com.data.ss19.service.bt4.ScreenRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/screen-rooms")
public class ScreenRoomController {
    @Autowired
    private ScreenRoomService screenRoomService;
    @Autowired
    private TheaterService theaterService;
    @Autowired
    private SeatRepository seatRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public String listScreenRooms(Model model) {
        List<ScreenRoom> screenRooms = screenRoomService.findByStatus(true);

        for (ScreenRoom sr : screenRooms) {
            long seatCount = seatRepository.countByScreenRoomId(sr.getId());
        }

        model.addAttribute("screenRooms", screenRooms);
        return "bt4/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("screenRoom", new ScreenRoom());
        model.addAttribute("theaters", theaterService.findByStatus(true));
        return "bt4/form";
    }

    @PostMapping("/add")
    public String addScreenRoom(@ModelAttribute("screenRoom") @Valid ScreenRoom screenRoom,
                                BindingResult result,
                                @RequestParam("theaterId") Long theaterId,
                                Model model) {
        if (result.hasErrors()) {
            model.addAttribute("theaters", theaterService.findByStatus(true));
            return "bt4/form";
        }

        Theater theater = theaterService.findById(theaterId);
        screenRoom.setTheater(theater);

        screenRoomService.save(screenRoom);
        return "redirect:/screen-rooms";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        ScreenRoom screenRoom = screenRoomService.findById(id);
        if (screenRoom == null) {
            return "redirect:/screen-rooms";
        }
        model.addAttribute("screenRoom", screenRoom);
        model.addAttribute("theaters", theaterService.findByStatus(true));
        return "bt4/form";
    }

    @PostMapping("/edit/{id}")
    public String editScreenRoom(@PathVariable Long id,
                                 @ModelAttribute("screenRoom") @Valid ScreenRoom screenRoom,
                                 BindingResult result,
                                 @RequestParam("theaterId") Long theaterId,
                                 Model model) {
        if (result.hasErrors()) {
            model.addAttribute("theaters", theaterService.findByStatus(true));
            return "bt4/form";
        }

        Theater theater = theaterService.findById(theaterId);
        screenRoom.setId(id);
        screenRoom.setTheater(theater);
        screenRoomService.update(screenRoom);
        return "redirect:/screen-rooms";
    }

    @GetMapping("/delete/{id}")
    public String deleteScreenRoom(@PathVariable Long id) {
        screenRoomService.delete(id);
        return "redirect:/screen-rooms";
    }

    @GetMapping("/seats/{id}")
    @Transactional(readOnly = true)
    public String viewSeats(@PathVariable Long id, Model model) {
        ScreenRoom screenRoom = screenRoomService.findById(id);
        if (screenRoom == null) {
            return "redirect:/screen-rooms";
        }

        List<Seat> seats = seatRepository.findByScreenRoomId(id);

        model.addAttribute("screenRoom", screenRoom);
        model.addAttribute("seats", seats);
        return "bt4/seats";
    }
}