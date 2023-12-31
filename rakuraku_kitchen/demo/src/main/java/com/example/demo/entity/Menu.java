package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;




@Data
@Entity
public class Menu { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String dish_name; //投稿者  
    String ingredient; //食材
    Long offer_weight; //提供重み  
    String recipe; //レシピ 
    
    public String getDish_name() {
        return dish_name;
    }
    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }
    
}

