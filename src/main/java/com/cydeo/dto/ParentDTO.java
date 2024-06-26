package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ParentDTO {

    @JsonIgnore
    private Long id;

    private String firstName;
    private String lastName;
    private String profession;
    private String phoneNumber;
    private String email;
    private String username;

    private String password;

    private LocalDate birthday;

    private String addressNo;

}
