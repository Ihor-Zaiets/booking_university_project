package com.university.booking_university_project.modules.apartment;

import com.university.booking_university_project.jpa.entity.Apartment;
import com.university.booking_university_project.modules.apartment.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentServiceImpl implements ApartmentService {

  private final ApartmentRepository apartmentRepository;

  @Autowired
  public ApartmentServiceImpl(ApartmentRepository apartmentRepository) {
    this.apartmentRepository = apartmentRepository;
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
}
