package com.example.demo.controller.orders;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Menu;
import com.example.demo.service.OrderService;

@Controller
public class OrderController2 {

    @Autowired
    OrderService os;
    private static final Logger logger = LoggerFactory.getLogger(OrderController2.class);


    //オーダーを登録画面の表示
    @GetMapping("/read2")
    public String showOrderInputForm(Model model) {
        List<Menu> menuLists = os.getDishname();
        model.addAttribute("menuLists", menuLists);
        return "ordertouroku";
    }
    
    @GetMapping("/read1")
    public String showOrderStatus(Model model) {
        List<Orders> cookingCompletedOrders = os.getCookingCompleted();
        List<Orders> servingCompletedOrders = os.getServingCompleted();
        List<Orders> beforeCookingOrders = os.getBeforeCooking();

        model.addAttribute("cookingCompletedOrders", cookingCompletedOrders);
        model.addAttribute("servingCompletedOrders", servingCompletedOrders);
        model.addAttribute("beforeCookingOrders", beforeCookingOrders);

        return "orderstatus";
    }
    /* 
    //オーダー状況画面の表示
    @GetMapping("/read1")
    public String showOrderStatus(Model model) {
        List<Orders> orderList = os.getAllorder(); //orderを取得
        model.addAttribute("orderList", orderList);
        return "orderstatus";
    }
    */
    //ordersに登録
    @RequestMapping(value="/read5",method = RequestMethod.POST, name = "getButtonValues")
    public String getButtonValue(HttpServletRequest req, Model model) throws Exception {
        String selectButtonValue = req.getParameter("getButtonValues");
        Orders o = new Orders();
        os.registerOrder(o, selectButtonValue);
        return "redirect:/read1";

    }

    //ordersを遷移
    @RequestMapping(value="/read6",method = RequestMethod.POST, name = "getButtonValues1")
    public String getButtonValue1(HttpServletRequest req, Model model) throws Exception {
        String selectButtonValue1String = req.getParameter("getButtonValues1");
        Long selectButtonValue1 = Long.parseLong(selectButtonValue1String);
        logger.info("取得したID: " + selectButtonValue1);
        os.transforOrder(selectButtonValue1);
        return "redirect:/read1";

    }






}


