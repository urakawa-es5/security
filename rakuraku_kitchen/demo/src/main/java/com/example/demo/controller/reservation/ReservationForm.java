package com.example.demo.controller.reservation;

import lombok.Data;

@Data

public class ReservationForm {
    private String name;
    private int numberOfPeople;
    private String dateTime;
}