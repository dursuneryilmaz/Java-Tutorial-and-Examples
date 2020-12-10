package com.dursuneryilmaz.mobileappws.ui.controller;

import com.dursuneryilmaz.mobileappws.service.impl.UserService;
import com.dursuneryilmaz.mobileappws.shared.dto.AddressDto;
import com.dursuneryilmaz.mobileappws.shared.dto.UserDto;
import com.dursuneryilmaz.mobileappws.ui.model.response.AddressRest;
import com.dursuneryilmaz.mobileappws.ui.model.response.UserRest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @InjectMocks
    UserController userController;
    @Mock
    UserService userService;
    @Mock
    ModelMapper modelMapper;

    UserDto userDto;
    UserRest userRest;

    final String USER_ID = "bfhry47fhdjd7463gdh";

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        userDto = new UserDto();
        userDto.setFirstName("Dursun");
        userDto.setLastName("Eryılmaz");
        userDto.setEmail("test@test.com");
        userDto.setEmailVerificationStatus(Boolean.FALSE);
        userDto.setEmailVerificationToken(null);
        userDto.setUserId(USER_ID);
        userDto.setAddresses(getAddressesDto());
        userDto.setEncryptedPassword("xcf58tugh47");

        userRest = new UserRest();
        userRest.setFirstName("Dursun");
        userRest.setLastName("Eryılmaz");
        userRest.setEmail("test@test.com");
        userRest.setUserId(USER_ID);
        userRest.setAddresses(getAddressRestList());

    }

    @Test
    final void testGetUser() {
        when(userService.getUserByUserId(anyString())).thenReturn(userDto);
        // pass conversion dto to rest
        when(modelMapper.map(any(UserDto.class), eq(UserRest.class))).thenReturn(userRest);

        UserRest userRest = userController.getUser(USER_ID);

        assertNotNull(userRest);
        assertEquals(USER_ID, userRest.getUserId());
        assertEquals(userDto.getFirstName(), userRest.getFirstName());
        assertEquals(userDto.getLastName(), userRest.getLastName());
        assertTrue(userDto.getAddresses().size() == userRest.getAddresses().size());
    }


    private List<AddressDto> getAddressesDto() {
        AddressDto addressDto = new AddressDto();
        addressDto.setType("shipping");
        addressDto.setCity("Kocaeli");
        addressDto.setCountry("Turkey");
        addressDto.setPostalCode("41000");
        addressDto.setStreetName("test street");

        AddressDto billingAddressDto = new AddressDto();
        billingAddressDto.setType("billling");
        billingAddressDto.setCity("Kocaeli");
        billingAddressDto.setCountry("Turkey");
        billingAddressDto.setPostalCode("41000");
        billingAddressDto.setStreetName("test street");

        List<AddressDto> addresses = new ArrayList<>();
        addresses.add(addressDto);
        addresses.add(billingAddressDto);

        return addresses;
    }

    // get address entities, converted from provided dto list
    private List<AddressRest> getAddressRestList() {
        List<AddressDto> addresses = getAddressesDto();
        Type listType = new TypeToken<List<AddressRest>>() {
        }.getType();
        return new ModelMapper().map(addresses, listType);
    }
}