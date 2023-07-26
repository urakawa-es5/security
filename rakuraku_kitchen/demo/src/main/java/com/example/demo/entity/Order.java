package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long dishid;
    private int dishcount;
    @Temporal(TemporalType.TIMESTAMP)
    Date ordertime; //作成日時
    private String tukuenumber;
    private String order;
    private String orderstatus;
    private String reservationflag;

    // コンストラクタ、getter、setterなどは省略
}

