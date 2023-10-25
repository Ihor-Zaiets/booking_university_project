package com.university.booking_university_project.jpa;

import java.io.Serializable;

public interface IdEntity<T> extends Serializable {
    T getId();

    void setId(T id);
}
