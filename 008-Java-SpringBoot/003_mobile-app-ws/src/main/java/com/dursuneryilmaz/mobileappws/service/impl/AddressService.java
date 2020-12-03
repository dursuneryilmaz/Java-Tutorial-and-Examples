package com.dursuneryilmaz.mobileappws.service.impl;

import com.dursuneryilmaz.mobileappws.io.entity.AddressEntity;
import com.dursuneryilmaz.mobileappws.io.entity.UserEntity;
import com.dursuneryilmaz.mobileappws.io.repository.IAddressRepository;
import com.dursuneryilmaz.mobileappws.io.repository.IUserRepository;
import com.dursuneryilmaz.mobileappws.service.IAddressService;
import com.dursuneryilmaz.mobileappws.shared.dto.AddressDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService implements IAddressService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IAddressRepository addressRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<AddressDto> getAddressesByUserId(String userId) {
        List<AddressDto> returnedValue = new ArrayList<>();

        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null) return null;
        Iterable<AddressEntity> addressEntities = addressRepository.findAllByUserDetails(userEntity);
        for (AddressEntity addressEntity : addressEntities) {
            returnedValue.add(modelMapper.map(addressEntity, AddressDto.class));
        }
        return returnedValue;
    }

    @Override
    public AddressDto getAddressByAddressId(String addressId) {
        return modelMapper.map(addressRepository.findByAddressId(addressId), AddressDto.class);
    }
}
