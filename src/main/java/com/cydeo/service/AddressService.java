package com.cydeo.service;

import com.cydeo.dto.AddressDTO;

public interface AddressService {

    AddressDTO findByAddressNo(String addressNo);

    AddressDTO update(String addressNo, AddressDTO addressDTO) ;

}
