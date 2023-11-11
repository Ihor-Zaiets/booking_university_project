package com.university.booking_university_project.modules.apartment;

import com.github.dozermapper.core.Mapper;
import com.university.booking_university_project.jpa.entity.Apartment;
import com.university.booking_university_project.modules.apartment.dto.ApartmentCreationDTO;
import com.university.booking_university_project.modules.apartment.dto.ApartmentDTO;
import com.university.booking_university_project.modules.apartment.dto.ApartmentUpdateDTO;
import com.university.booking_university_project.modules.apartment.repository.ApartmentRepository;
import com.university.booking_university_project.validators.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApartmentServiceImpl implements ApartmentService {

  private final ApartmentRepository apartmentRepository;

  private final Mapper mapper;

  @Autowired
  public ApartmentServiceImpl(ApartmentRepository apartmentRepository, Mapper mapper) {
    this.apartmentRepository = apartmentRepository;
    this.mapper = mapper;
  }

  @Override
  public List<Apartment> saveAll(List<Apartment> apartments) {
    return apartmentRepository.saveAll(apartments);
  }

  @Override
  public void deleteAll(List<Apartment> apartments) {
    apartmentRepository.deleteAll(apartments);
  }

  @Override
  public void deleteAllByIds(List<Integer> ids) {
    apartmentRepository.deleteAllById(ids);
  }

  @Override
  public Optional<Apartment> findById(Integer id) {
    return apartmentRepository.findById(id);
  }

  @Override
  public List<ApartmentDTO> createApartments(List<ApartmentCreationDTO> apartmentCreationDTOList) {
    List<Apartment> apartments = new ArrayList<>();
    for (ApartmentCreationDTO apartmentCreationDTO : apartmentCreationDTOList) {
      validateApartment(apartmentCreationDTO);
      apartments.add(mapper.map(apartmentCreationDTO, Apartment.class));
    }
    apartments = apartmentRepository.saveAll(apartments);
    return apartments.stream().map(apartment -> mapper.map(apartment, ApartmentDTO.class)).collect(Collectors.toList());
  }

  private <DTO extends ApartmentUpdateDTO> void validateApartment(DTO apartmentCreationDTO) {
    Validation.validateNumberMoreThen0(apartmentCreationDTO.getFloor());
    Validation.validateNumberMoreThen0(apartmentCreationDTO.getSquare());
    Validation.validateNumberMoreThen0(apartmentCreationDTO.getRentPrice());
    Validation.validateNumberMoreThen0(apartmentCreationDTO.getNumberOfRooms());
    Validation.validateNumberMoreThen0(apartmentCreationDTO.getNumberOfDoubleBeds());
    Validation.validateNumberMoreThen0(apartmentCreationDTO.getNumberOfSingleBeds());
  }

  @Override
  public List<ApartmentDTO> findAllDTO() {
    return apartmentRepository.findAll().stream().map(entity -> mapper.map(entity, ApartmentDTO.class)).collect(Collectors.toList());
  }

  @Override
  public List<ApartmentDTO> editApartments(List<ApartmentUpdateDTO> apartmentUpdateDTOList) {
    List<Apartment> apartments = new ArrayList<>();
    for (ApartmentUpdateDTO apartmentUpdateDTO : apartmentUpdateDTOList) {
      validateApartment(apartmentUpdateDTO);
      apartments.add(mapper.map(apartmentUpdateDTO, Apartment.class));
    }
    apartments = apartmentRepository.saveAll(apartments);
    return apartments.stream().map(apartment -> mapper.map(apartment, ApartmentDTO.class)).collect(Collectors.toList());
  }
}
