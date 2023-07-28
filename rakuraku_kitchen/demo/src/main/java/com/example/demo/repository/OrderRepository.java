package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    // ここに必要なカスタムクエリやメソッドを追加できます
    List<Orders> findByStatus(String orders);
}
