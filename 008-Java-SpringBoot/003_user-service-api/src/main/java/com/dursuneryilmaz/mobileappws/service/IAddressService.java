package com.dursuneryilmaz.mobileappws.service;

import com.dursuneryilmaz.mobileappws.shared.dto.AddressDto;

import java.util.List;

public interface IAddressService {
    List<AddressDto> getAddressesByUserId(String userId);

    AddressDto getAddressByAddressId(String addressId);

}
