package com.university.booking_university_project.modules.apartment;

import com.university.booking_university_project.modules.apartment.dto.ApartmentCreationDTO;
import com.university.booking_university_project.modules.apartment.dto.ApartmentDTO;
import com.university.booking_university_project.modules.apartment.dto.ApartmentUpdateDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Apartment")
public class ApartmentController {

    private final ApartmentService apartmentService;

    @Autowired
    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @PostMapping("/createAll")
    public ResponseEntity<List<ApartmentDTO>> createApartments(
            @RequestBody List<ApartmentCreationDTO> ApartmentCreationDTOList
    ) {
        return ResponseEntity.ok(apartmentService.createApartments(ApartmentCreationDTOList));
    }

    @GetMapping("/searchAll")
    public ResponseEntity<List<ApartmentDTO>> findAllApartments() {
        return ResponseEntity.ok(apartmentService.findAllDTO());
    }

    @PatchMapping("/editAll")
    public ResponseEntity<List<ApartmentDTO>> editApartments(
            @RequestBody List<ApartmentUpdateDTO> ApartmentCreationDTO
    ) {
        return ResponseEntity.ok(apartmentService.editApartments(ApartmentCreationDTO));
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteApartments(@RequestBody List<Integer> ids) {
        apartmentService.deleteAllByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/forUsers")
    public ResponseEntity<List<ApartmentDTO>> findApartmentsForUsers() {
        return ResponseEntity.ok(apartmentService.findApartmentsForUsers());
    }
}
