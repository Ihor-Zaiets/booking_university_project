package com.university.booking_university_project.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

import java.util.Objects;

@Entity
public class Apartment {

    @Id
    private Long id;

    @NonNull
    private Integer numberOfRooms;

    private Double square;

    @NonNull
    private Double rentPrice;

    private Integer floor;

    private String description;

    @NonNull
    private Integer numberOfDoubleBeds;

    @NonNull
    private Integer numberOfSingleBeds;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @NonNull
    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Double getSquare() {
        return square;
    }

    public void setSquare(Double square) {
        this.square = square;
    }

    @NonNull
    public Double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    public Integer getNumberOfDoubleBeds() {
        return numberOfDoubleBeds;
    }

    public void setNumberOfDoubleBeds(Integer hasDoubleBed) {
        this.numberOfDoubleBeds = hasDoubleBed;
    }

    @NonNull
    public Integer getNumberOfSingleBeds() {
        return numberOfSingleBeds;
    }

    public void setNumberOfSingleBeds(Integer hasSingleBed) {
        this.numberOfSingleBeds = hasSingleBed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apartment apartment)) return false;
        return Objects.equals(getId(), apartment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
