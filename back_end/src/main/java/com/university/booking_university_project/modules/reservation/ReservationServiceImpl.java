package com.university.booking_university_project.modules.reservation;

import com.university.booking_university_project.jpa.entity.Reservation;
import com.university.booking_university_project.modules.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

  private final ReservationRepository reservationRepository;

  @Autowired
  public ReservationServiceImpl(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @Override
  public List<Reservation> saveAll(List<Reservation> reservations) {
    return reservationRepository.saveAll(reservations);
  }

  @Override
  public void deleteAll(List<Reservation> reservations) {
    reservationRepository.deleteAll(reservations);
  }

  @Override
  public void deleteAllByIds(List<Integer> ids) {
    reservationRepository.deleteAllById(ids);
  }

  @Override
  public Optional<Reservation> findById(Integer id) {
    return reservationRepository.findById(id);
  }
}
