package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data

@Entity

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int numberOfPeople;
    private String dateTime;
    private String dishname;
    private int tablenumber;
    // コンストラクタ、ゲッター、セッターなどを定義する
    public void setTable_number(int tablenumber) {
    }
}
