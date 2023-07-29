package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

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
    public List<Menu> getAllmunMenu() {
        Iterable<Menu> found = repo.findAll();
        ArrayList<Menu> list = new ArrayList<>();
        found.forEach(list::add);
        return list;
    }
    private final MenuRepository menuRepository;
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
      }
}