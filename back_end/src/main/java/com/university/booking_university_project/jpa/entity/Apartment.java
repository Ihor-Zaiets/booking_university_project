package com.university.booking_university_project.jpa.entity;

import com.university.booking_university_project.jpa.IEntity;
import jakarta.persistence.*;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@Table(schema = "public", name = "apartment")
@Entity
public class Apartment implements IEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    @NonNull
    private String address;

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
