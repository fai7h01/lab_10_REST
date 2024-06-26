package com.cydeo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "parents")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Parent extends BaseEntity {

    private String firstName;
    private String lastName;
    private String profession;
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(columnDefinition = "DATE")
    private LocalDate birthday;

    private String addressNo;

}
