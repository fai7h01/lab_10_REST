package com.cydeo.dto;

import com.cydeo.enums.EducationLevel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TeacherDTO {

    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String username;

    private String password;

    private LocalDate birthday;
    private EducationLevel educationLevel;

    private String addressNo;

}
