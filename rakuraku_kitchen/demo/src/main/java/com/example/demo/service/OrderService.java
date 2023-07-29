package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository repo; // レポジトリ

    @Autowired
    MenuRepository mrepo;

    // 全オーダーを取得
    public List<Orders> getAllorder() {
        Iterable<Orders> found = repo.findAll(); 
        ArrayList<Orders> list = new ArrayList<>();
        found.forEach(list::add);
        return list;
    }  

    // メニューから料理のリストを取得
    public List<Menu> getDishname() { 
        Iterable<Menu> menus = mrepo.findAll();
        ArrayList<Menu> menuList = new ArrayList<>();
        menus.forEach(menuList::add);
        return menuList;
    }
    
    // オーダーの状況を登録
    public Orders registerOrder(Orders o, String dishname) {
        o.setDishname(dishname);
        o.setStatus("料理前");
        o.setOrdertime(new Date());
        return repo.save(o);
        }

    public Orders transforOrder(Long id) {
        Optional<Orders> optionalOrder = repo.findById(id);
        if (optionalOrder.isPresent()) {
            Orders orders = optionalOrder.get();
            String status = orders.getStatus();

            if ("料理前".equals(status)) {
                orders.setStatus("料理完了");
            } else if ("料理完了".equals(status)) {
                orders.setStatus("配膳完了");
            } else if ("配膳完了".equals(status)) {
                orders.setStatus("料理前");
            } else {
                // オーダーのステータスが上記以外の場合は例外をスロー
                throw new RuntimeException("無効なステータスです");
            }

            // 変更したステータスを保存して返す
            return repo.save(orders);
        } else {
            throw new RuntimeException("指定されたIDのオーダーが見つかりません");
        }
    }
    public List<Orders> getOrdersByStatus(String status) {
        List<Orders> allOrders = repo.findAll();
        List<Orders> filteredOrders = new ArrayList<>();

        for (Orders order : allOrders) {
            if (order.getStatus().equals(status)) {
                filteredOrders.add(order);
            }
        }

        return filteredOrders;
    }

    public List<Orders> getCookingCompleted() {
        return getOrdersByStatus("料理完了");
    }

    public List<Orders> getServingCompleted() {
        return getOrdersByStatus("配膳完了");
    }

    public List<Orders> getBeforeCooking() {
        return getOrdersByStatus("料理前");
    }

    private final  OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public void deleteOrder(Long id) {
       orderRepository.deleteById(id);
      }
}
