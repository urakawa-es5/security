package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuRepository;

@Service
public class MenuService {
    @Autowired  
    MenuRepository repo; // レポジトリ  
    // つぶやきを投稿  
    public Menu postMenu(Menu t) {   
        return repo.save(t); //セーブしたオブジェクトを返却
}
}