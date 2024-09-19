package com.university.booking_university_project.jpa;

/**
 * This class created to get access to {@link #getId()} on generics.
 *
 * <p>To use generics i wrote ENTITY as type parameter on test class, but there was a problem, when i needed an id.
 * So this class just clearly indicates, that entity used in test has getId method.
 */
public interface IEntity<ID> {
    ID getId();

    void setId(ID id);
}
