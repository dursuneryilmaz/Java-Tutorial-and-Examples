package com.dursuneryilmaz.mobileappws.service;

import com.dursuneryilmaz.mobileappws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    UserDto createUser(UserDto user);

    UserDto getUserByEmail(String email);

    UserDto getUserByUserId(String userId);
}
