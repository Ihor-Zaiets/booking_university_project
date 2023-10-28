package com.university.booking_university_project.jpa.entity;

import com.university.booking_university_project.jpa.IEntity;
import com.university.booking_university_project.jpa.enums.ReservationStatus;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.sql.Timestamp;
import java.util.Objects;

@Table(schema = "public", name = "reservation")
@Entity
public class Reservation implements IEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NonNull
    private Timestamp start_date;

    @NonNull
    private Timestamp end_date;

    @NonNull
    private Integer numberOfPeople;

    @NonNull
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @NonNull
    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(@NonNull Apartment apartment) {
        this.apartment = apartment;
    }

    @NonNull
    public User getUser() {
        return user;
    }

    public void setUser(@NonNull User user) {
        this.user = user;
    }

    @NonNull
    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(@NonNull Timestamp start_date) {
        this.start_date = start_date;
    }

    @NonNull
    public Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(@NonNull Timestamp end_date) {
        this.end_date = end_date;
    }

    @NonNull
    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(@NonNull Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    @NonNull
    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(@NonNull ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
