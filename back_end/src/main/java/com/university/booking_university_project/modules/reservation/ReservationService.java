package com.university.booking_university_project.modules.reservation;

import com.university.booking_university_project.jpa.entity.Reservation;
import com.university.booking_university_project.modules.BaseService;
import com.university.booking_university_project.modules.reservation.dto.ReservationCreationDTO;
import com.university.booking_university_project.modules.reservation.dto.ReservationDTO;
import com.university.booking_university_project.modules.reservation.dto.ReservationUpdateDTO;
import java.util.List;

public interface ReservationService extends BaseService<Reservation, Integer> {
    List<ReservationDTO> createReservations(List<ReservationCreationDTO> reservationCreationDTOList);

    List<ReservationDTO> findAllDTO();

    List<ReservationDTO> editReservations(List<ReservationUpdateDTO> reservationCreationDTO);
}
