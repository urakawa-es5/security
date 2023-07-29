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

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Temporal(TemporalType.TIMESTAMP)
    Date ordertime; //作成日時

    private String dishname;
    private String status; 

    public String getDishname() {
        return dishname;
    }
    public void setDishname(String dishname) {
        this.dishname = dishname;
    }
        public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getOrdertime() {
        return ordertime;
    }
    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    // コンストラクタ、getter、setterなどは省略
    }

}

