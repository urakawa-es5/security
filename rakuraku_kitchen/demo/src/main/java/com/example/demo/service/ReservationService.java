package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.entity.Reservation;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository repo;

    public List<Reservation> getAllReservations() {
        Iterable<Reservation> found = repo.findAll();
        ArrayList<Reservation> list = new ArrayList<>();
        found.forEach(list::add);
        return list;
    }

    public Reservation registerReservation(Reservation r) {
        return repo.save(r);
    }

    private final   ReservationRepository  reservationRepository;
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    public void deleteResevation(Long id) {
      reservationRepository.deleteById(id);
      }

}
