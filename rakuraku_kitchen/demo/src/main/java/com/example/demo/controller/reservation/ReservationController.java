package com.example.demo.controller.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Reservation;
import com.example.demo.service.ReservationService;

@Controller
public class ReservationController {
    @Autowired
    ReservationService rs;

    @GetMapping("/read")
    String ReservationList(Model model) {
        List<Reservation> reservations = rs.getAllReservations();
        model.addAttribute("reservationList", reservations);
        model.addAttribute("reservationForm", new Reservation());
        return "showReserve";
    }

    @PostMapping("/read")
    String postReservation(@ModelAttribute("reservationForm") ReservationForm form, Model model) {
        Reservation r = new Reservation();
        r.setName(form.getName());
        r.setNumberOfPeople(form.getNumberOfPeople());
        r.setDateTime(form.getDateTime());
        r.setDishname(form.getDishname());
        r.setTablenumber(form.getTablenumber());
        rs.registerReservation(r);
        return "redirect:/read";
    }

}
