package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Reservation;
import com.example.demo.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public Reservation registerReservation(@RequestBody ReservationRequest request) {
        return reservationService.registerReservation(request.getName(), request.getNumberOfPeople(),
                                                     request.getDateTime(), request.getDish(),
                                                     request.getSelectedCourse());
    }

    // 他に必要なエンドポイントを追加する
}