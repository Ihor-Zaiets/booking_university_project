package com.university.booking_university_project.modules.reservation;

import com.university.booking_university_project.modules.reservation.dto.ReservationCreationDTO;
import com.university.booking_university_project.modules.reservation.dto.ReservationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

  private final ReservationService reservationService;

  public ReservationController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }
  
  @PostMapping("/createAll")
  public ResponseEntity<List<ReservationDTO>> createReservations(@RequestBody List<ReservationCreationDTO> reservationCreationDTOList) {
    return ResponseEntity.ok(reservationService.createReservations(reservationCreationDTOList));
  }

  @GetMapping("/searchAll")
  public ResponseEntity<List<ReservationDTO>> findAllReservations() {
    return ResponseEntity.ok(reservationService.findAllDTO());
  }

  @PostMapping("/editAll")
  public ResponseEntity<List<ReservationDTO>> editReservations(@RequestBody ReservationCreationDTO reservationCreationDTO) {
    return ResponseEntity.ok(reservationService.editReservations(reservationCreationDTO));
  }

  @DeleteMapping("/deleteAll")
  public ResponseEntity<Void> deleteReservations(@RequestBody List<Integer> ids) {
    reservationService.deleteAllByIds(ids);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
