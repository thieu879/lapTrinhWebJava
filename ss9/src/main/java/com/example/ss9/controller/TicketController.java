package com.example.ss9.controller;

import com.example.ss9.model.Schedule;
import com.example.ss9.service.ScheduleService;
import com.example.ss9.service.ScheduleServiceImpl;
import com.example.ss9.service.ScreenRoomService;
import com.example.ss9.service.ScreenRoomServiceImpl;
import com.example.ss9.service.SeatService;
import com.example.ss9.service.SeatServiceImpl;
import com.example.ss9.service.TicketService;
import com.example.ss9.service.TicketServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TicketController {
    private final ScheduleService scheduleService = new ScheduleServiceImpl();
    private final ScreenRoomService screenRoomService = new ScreenRoomServiceImpl();
    private final SeatService seatService = new SeatServiceImpl();
    private final TicketService ticketService = new TicketServiceImpl();

    @GetMapping("/bookTicket")
    public String showBookingPage(@RequestParam("scheduleId") Long scheduleId, Model model) {
        List<Schedule> allSchedules = scheduleService.findAllSchedulesByMovie(
                scheduleService.findAllSchedulesByMovie("Inception").get(0).getMovieTitle()
        );
        Schedule schedule = allSchedules.stream()
                .filter(s -> s.getId().equals(scheduleId))
                .findFirst()
                .orElse(null);

        if (schedule == null) {
            model.addAttribute("error", "Invalid schedule");
            return "detailMovie";
        }

        model.addAttribute("schedule", schedule);
        model.addAttribute("screenRoom", screenRoomService.getScreenRoomById(schedule.getScreenRoomId()));
        model.addAttribute("seats", seatService.getSeatsByScreenRoom(schedule.getScreenRoomId()));
        return "bookTicket";
    }

    @PostMapping("/bookTicket")
    public String processBooking(
            @RequestParam("scheduleId") Long scheduleId,
            @RequestParam(value = "seatIds", required = false) String seatIds,
            HttpSession session,
            Model model) {
        Long customerId = (Long) session.getAttribute("customerId");
        if (customerId == null) {
            model.addAttribute("error", "Please login to book tickets");
            return "login";
        }

        if (seatIds == null || seatIds.trim().isEmpty()) {
            model.addAttribute("error", "Please select at least one seat");
            List<Schedule> allSchedules = scheduleService.findAllSchedulesByMovie(
                    scheduleService.findAllSchedulesByMovie("Inception").get(0).getMovieTitle()
            );
            Schedule schedule = allSchedules.stream()
                    .filter(s -> s.getId().equals(scheduleId))
                    .findFirst()
                    .orElse(null);
            model.addAttribute("schedule", schedule);
            model.addAttribute("screenRoom", screenRoomService.getScreenRoomById(schedule.getScreenRoomId()));
            model.addAttribute("seats", seatService.getSeatsByScreenRoom(schedule.getScreenRoomId()));
            return "bookTicket";
        }

        List<Long> seatIdList = Arrays.stream(seatIds.split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        Double totalMoney = seatIdList.size() * 50000.0;

        Long ticketId = ticketService.addTicket(customerId, scheduleId, totalMoney, seatIds);
        if (ticketId != null) {
            model.addAttribute("message", "Ticket booked successfully! Total: " + totalMoney);
            return "bookTicket";
        } else {
            model.addAttribute("error", "Failed to book ticket");
            List<Schedule> allSchedules = scheduleService.findAllSchedulesByMovie(
                    scheduleService.findAllSchedulesByMovie("Inception").get(0).getMovieTitle()
            );
            Schedule schedule = allSchedules.stream()
                    .filter(s -> s.getId().equals(scheduleId))
                    .findFirst()
                    .orElse(null);
            model.addAttribute("schedule", schedule);
            model.addAttribute("screenRoom", screenRoomService.getScreenRoomById(schedule.getScreenRoomId()));
            model.addAttribute("seats", seatService.getSeatsByScreenRoom(schedule.getScreenRoomId()));
            return "bookTicket";
        }
    }
}