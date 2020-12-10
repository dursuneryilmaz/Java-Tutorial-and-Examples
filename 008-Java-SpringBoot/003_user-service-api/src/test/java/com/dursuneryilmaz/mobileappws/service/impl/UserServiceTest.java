package com.dursuneryilmaz.mobileappws.service.impl;

import com.dursuneryilmaz.mobileappws.io.entity.AddressEntity;
import com.dursuneryilmaz.mobileappws.io.entity.UserEntity;
import com.dursuneryilmaz.mobileappws.io.repository.IUserRepository;
import com.dursuneryilmaz.mobileappws.shared.dto.AddressDto;
import com.dursuneryilmaz.mobileappws.shared.dto.UserDto;
import com.dursuneryilmaz.mobileappws.shared.utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
 * if main codes changes maven built triggers the testcases and build fails.
 * */
class UserServiceTest {
    // this cannot be mocked it must be real object, this provided @InjectMocks annotation.
    @InjectMocks
    UserService userService;
    // mock objects to be injected
    @Mock
    IUserRepository userRepository;
    @Mock
    GmailService gmailService;
    @Mock
    Utils utils;
    @Mock
    ModelMapper modelMapper;
    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;


    // dummy properties
    UserEntity userEntity;
    UserDto storedUserDto;
    String userId = "sgjkhkl4522423";
    String encryptedPassword = "ghj5k493EQ25022";
    String verificationToken = "kjh3kj453i6";

    @BeforeEach
    void setUp() {
        // for mockito be able to instantiate objects
        MockitoAnnotations.openMocks(this);
        // step object to use in tests
        userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setFirstName("Dursun");
        userEntity.setLastName("Eryılmaz");
        userEntity.setUserId(userId);
        userEntity.setEncryptedPassword(encryptedPassword);
        userEntity.setEmail("test@test.com");
        userEntity.setEmailVerificationToken(verificationToken);
        userEntity.setAddresses(getAddressEntities());


        storedUserDto = new UserDto();
        storedUserDto.setId(1L);
        storedUserDto.setFirstName("Dursun");
        storedUserDto.setLastName("Eryılmaz");
        storedUserDto.setUserId(userId);
        storedUserDto.setEncryptedPassword(encryptedPassword);
        storedUserDto.setEmail("test@test.com");
        storedUserDto.setEmailVerificationToken(verificationToken);
        storedUserDto.setAddresses(getAddressDtoList());
    }

    @Test
    void getUserByEmail() {
        // use step object for to return on repository findByEmail method
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

    @Test
    final void testCreateUser() {
        // pass duplicated email
        when(userRepository.findByEmail(anyString())).thenReturn(null);
        // pass generate address id
        when(utils.generateAddressId(anyInt())).thenReturn("asjflk352tgreg2");
        // pass object mapping dto to entity
        when(modelMapper.map(any(UserDto.class), eq(UserEntity.class))).thenReturn(userEntity);
        // pass generate user id
        when(utils.generateUserId(anyInt())).thenReturn("sfshdflkjk39tweotp23kt20");
        // pass generate encrypted password
        when(bCryptPasswordEncoder.encode(anyString())).thenReturn(encryptedPassword);
        // pass generate email verification token
        when(utils.generateEmailVerificationToken(anyString())).thenReturn(verificationToken);
        // pass entity save
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);
        // pass convertion stored entity to stored dto
        when(modelMapper.map(any(UserEntity.class), eq(UserDto.class))).thenReturn(storedUserDto);
        // pass verification email send
        when(gmailService.sendVerificationEmail(any(UserDto.class))).thenReturn(true);

        UserDto userDto = new UserDto();
        userDto.setAddresses(getAddressDtoList());
        userDto.setFirstName("Dursun");
        userDto.setLastName("Eryılmaz");
        userDto.setPassword("12345678");
        userDto.setEmail("test@test.com");

        UserDto storedUserDetails = userService.createUser(userDto);
        assertNotNull(storedUserDetails);
        assertEquals(userEntity.getFirstName(), storedUserDetails.getFirstName());
        assertEquals(userEntity.getLastName(), storedUserDetails.getLastName());
        assertNotNull(storedUserDetails.getUserId());
        assertEquals(storedUserDetails.getAddresses().size(), userEntity.getAddresses().size());
        verify(utils, times(storedUserDetails.getAddresses().size())).generateAddressId(32);
        verify(bCryptPasswordEncoder, times(1)).encode("12345678");
        verify(userRepository, times(1)).save(any(UserEntity.class));
    }


    // provide test address dto list
    private List<AddressDto> getAddressDtoList() {
        AddressDto shippingAddressDto = new AddressDto();
        shippingAddressDto.setType("shipping");
        shippingAddressDto.setCity("Kocaeli");
        shippingAddressDto.setCountry("Turkey");
        shippingAddressDto.setPostalCode("41000");
        shippingAddressDto.setStreetName("test street");

        AddressDto billingAddressDto = new AddressDto();
        billingAddressDto.setType("billling");
        billingAddressDto.setCity("Kocaeli");
        billingAddressDto.setCountry("Turkey");
        billingAddressDto.setPostalCode("41000");
        billingAddressDto.setStreetName("test street");

        List<AddressDto> addresses = new ArrayList<>();
        addresses.add(shippingAddressDto);
        addresses.add(billingAddressDto);

        return addresses;

    }

    // get address entities, converted from provided dto list
    private List<AddressEntity> getAddressEntities() {
        List<AddressDto> addresses = getAddressDtoList();
        Type listType = new TypeToken<List<AddressEntity>>() {
        }.getType();
        return new ModelMapper().map(addresses, listType);
    }
}