package com.dursuneryilmaz.mobileappws.service.impl;

import com.dursuneryilmaz.mobileappws.UserRepository;
import com.dursuneryilmaz.mobileappws.io.entity.UserEntity;
import com.dursuneryilmaz.mobileappws.service.IUserService;
import com.dursuneryilmaz.mobileappws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto user) {
        // check users by email to prevent duplication
        if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists");
        // encapsulate the db user id from transporting between layers
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        //hardcode required fields for test
        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("test");

        UserEntity storedUserDetails = userRepository.save(userEntity);
        UserDto returnedValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnedValue);

        return returnedValue;
    }
}
