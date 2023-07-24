package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.entity.Reservation;

@Service
public class ReservationService {
    private ReservationRepository repo;

    public List<Reservation> getAllReservations() {
        Iterable<Reservation> found = repo.findAll();
        ArrayList<Reservation> list = new ArrayList<>();
        found.forEach(list::add);
        return list;
    }

    public Reservation registerReservation(String name, int numberOfPeople, String dateTime, String selectedCourse) {
        // Entityのインスタンスを作成して予約情報を登録
        Reservation reservation = new Reservation();
        reservation.setName(name);
        reservation.setNumberOfPeople(numberOfPeople);
        reservation.setDateTime(dateTime);
        reservation.setSelectedCourse(selectedCourse);
        return repo.save(reservation);
    }

    // 他に必要なビジネスロジックを追加する
}
