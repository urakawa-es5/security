package com.example.demo.entity;

import javax.persistence.Entity;

import lombok.Data;

@Data

  
@Entity

public class Reservation {
    private Long id;
    private String name;
    private int numberOfPeople;
    private String dateTime;
    private String dish;
    private String selectedCourse;

    // コンストラクタ、ゲッター、セッターなどを定義する
}
