package com.example.demo.controller.menu;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Menu;
import com.example.demo.service.MenuService;

@Controller
public class MenuController{
    @Autowired
    MenuService ts;

    //タイトル画面を表示  
    @GetMapping("/")  
    String showIndex() {  
        return "home";  
    }

    @GetMapping("/read10")
    String showTsubuyakiList(Model model) {  
        model.addAttribute("menuRegistration", new MenuRegistration());  //空フォームをセット
        return "menu_registration"; //リスト画面を返す
    }

//つぶやきを投稿  
    @PostMapping("/read10")  
    String postMenu(@ModelAttribute("menuRegistration") MenuRegistration form, Model model) {  
        //フォームからエンティティに移し替え  
        Menu t = new Menu();  
        t.setDish_name(form.getDish_name());
        t.setIngredient(form.getIngredient());
        t.setOffer_weight(form.getOffer_weight());
        t.setRecipe(form.getRecipe()); 
        //サービスに投稿処理を依頼
        ts.postMenu(t);  
        return "redirect:/read10"; //メイン画面に転送  
    }

    @GetMapping("/read5")
    String menutalbe(Model model) {  
        List<Menu> menuLists = ts.getAllmunMenu();
        model.addAttribute("menuLists", menuLists);
        return "menutable"; 
    }

    @GetMapping("/read15/{id}")
    String menudelete(@PathVariable Long id, Model model) {  
       ts.deleteMenu(id);
       return "redirect:/read5";
    }
    
}