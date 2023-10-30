package com.university.booking_university_project.testUtils;

import com.university.booking_university_project.jpa.entity.Apartment;
import com.university.booking_university_project.jpa.entity.User;
import org.springframework.stereotype.Component;

@Component
public class TestUtils {

  public User createUserEntity(String name, String surname, String email, String phone, String address) {
    User user = new User();
    user.setFirstname(name);
    user.setSurname(surname);
    user.setEmail(email);
    user.setPhone(phone);
    user.setAddress(address);
    return user;
  }

  public Apartment createApartmentEntity(Integer numberOfRooms, Double square, Double rentPrice, Integer floor, String description, Integer numberOfSingleBeds, Integer numberOfDoubleBeds) {
    Apartment apartment = new Apartment();
    apartment.setNumberOfRooms(numberOfRooms);
    apartment.setSquare(square);
    apartment.setRentPrice(rentPrice);
    apartment.setFloor(floor);
    apartment.setDescription(description);
    apartment.setNumberOfSingleBeds(numberOfSingleBeds);
    apartment.setNumberOfDoubleBeds(numberOfDoubleBeds);
    return apartment;
  }
}
