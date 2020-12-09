package com.dursuneryilmaz.mobileappws.service.impl;

import com.dursuneryilmaz.mobileappws.io.entity.UserEntity;
import com.dursuneryilmaz.mobileappws.io.repository.IUserRepository;
import com.dursuneryilmaz.mobileappws.service.IUserService;
import com.dursuneryilmaz.mobileappws.shared.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.junit.jupiter.api.Assertions.*;

/*
 * if main codes changes maven built triggers the testcases and build fails.
 * */
class UserServiceTest {
    // this cannot be mocked it must be real object, this provided @InjectMocks annotation.
    @InjectMocks
    UserService userService;
    // mock object to be injected
    @Mock
    IUserRepository userRepository;

    @BeforeEach
    void setUp() {
        // for mockito be able to instantiate objects
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUserByEmail() {
        // Step object for to return on repository findByEmail method
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setFirstName("Dursun");
        userEntity.setUserId("asf43t53yhtbd");
        userEntity.setEncryptedPassword("afdgeg457547474");

        when(userRepository.findByEmail(anyString())).thenReturn(userEntity);
        UserDto userDto = userService.getUserByEmail("test@test.com");

        // test object is not null
        assertNotNull(userDto);
        // test bean utils works on bussiness logic side
        assertEquals("Dursun", userDto.getFirstName());
    }

    @Test
    void getUserByEmail_UsernameNotFoundException() {
        // test the exception in userService it throws right one
        when(userRepository.findByEmail(anyString())).thenReturn(null);
        assertThrows(UsernameNotFoundException.class,
                () -> {
                    userService.getUserByEmail("test@test.com");
                }
        );
    }
}