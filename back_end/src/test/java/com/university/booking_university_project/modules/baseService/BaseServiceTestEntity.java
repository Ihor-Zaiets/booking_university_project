package com.university.booking_university_project.modules.baseService;

import com.university.booking_university_project.jpa.IdEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class BaseServiceTestEntity implements IdEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String testAttribute;

    private Integer integerTestAttribute;

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getTestAttribute() {
        return testAttribute;
    }

    public void setTestAttribute(String testAttribute) {
        this.testAttribute = testAttribute;
    }

    public Integer getIntegerTestAttribute() {
        return integerTestAttribute;
    }

    public void setIntegerTestAttribute(Integer integerTestAttribute) {
        this.integerTestAttribute = integerTestAttribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseServiceTestEntity that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
