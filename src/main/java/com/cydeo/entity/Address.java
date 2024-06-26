package com.cydeo.entity;

import com.cydeo.enums.AddressType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
public class Address extends BaseEntity {

    @Column(updatable = false, unique = true)
    private String addressNo;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

}
