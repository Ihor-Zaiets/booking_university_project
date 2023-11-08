package com.university.booking_university_project.modules.apartment;

import com.university.booking_university_project.jpa.entity.Apartment;
import com.university.booking_university_project.modules.BaseService;
import com.university.booking_university_project.modules.apartment.dto.ApartmentCreationDTO;
import com.university.booking_university_project.modules.apartment.dto.ApartmentDTO;

import java.util.List;

public interface ApartmentService extends BaseService<Apartment, Integer> {
  List<ApartmentDTO> createApartments(List<ApartmentCreationDTO> apartmentCreationDTOList);

  List<ApartmentDTO> findAllDTO();

  List<ApartmentDTO> editApartments(ApartmentCreationDTO apartmentCreationDTO);
}
