package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.entity.Reservation;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation registerReservation(String name, int numberOfPeople, String dateTime,
                                           String dish, String selectedCourse) {
        // Entityのインスタンスを作成して予約情報を登録
        Reservation reservation = new Reservation();
        reservation.setName(name);
        reservation.setNumberOfPeople(numberOfPeople);
        reservation.setDateTime(dateTime);
        reservation.setDish(dish);
        reservation.setSelectedCourse(selectedCourse);

        return reservationRepository.save(reservation);
    }

    // 他に必要なビジネスロジックを追加する
}
