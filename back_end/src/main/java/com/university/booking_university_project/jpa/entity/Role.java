package com.university.booking_university_project.jpa.entity;

import com.university.booking_university_project.jpa.IEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.List;

@Setter
@Getter
@Entity
@Table(schema = "public", name = "role")
public class Role implements IEntity<Integer> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NonNull
  private String name;

  private String description;

  @ManyToMany
  @JoinTable(
          name = "user_role",
          joinColumns = @JoinColumn(name = "role_id"),
          inverseJoinColumns = @JoinColumn(name = "user_id")
  )
  private List<User> users;
}
