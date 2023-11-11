package com.university.booking_university_project.jpa.entity;

import com.university.booking_university_project.jpa.IEntity;
import com.university.booking_university_project.jpa.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
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
    private Timestamp startDate;

    @NonNull
    private Timestamp endDate;

    @NonNull
    private Integer numberOfPeople;

    @NonNull
    private Integer price;

    @NonNull
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

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
