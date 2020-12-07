package com.dursuneryilmaz.mobileappws.service.impl;

import com.dursuneryilmaz.mobileappws.exceptions.UserServiceException;
import com.dursuneryilmaz.mobileappws.io.repository.IUserRepository;
import com.dursuneryilmaz.mobileappws.io.entity.UserEntity;
import com.dursuneryilmaz.mobileappws.service.IUserService;
import com.dursuneryilmaz.mobileappws.shared.dto.AddressDto;
import com.dursuneryilmaz.mobileappws.shared.dto.UserDto;
import com.dursuneryilmaz.mobileappws.shared.utils.Utils;
import com.dursuneryilmaz.mobileappws.ui.model.response.ErrorMessages;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    Utils utils;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    GmailService gmailService;

    @Override
    public UserDto createUser(UserDto userDto) {
        // check users by email to prevent duplication
        if (userRepository.findByEmail(userDto.getEmail()) != null) throw new RuntimeException("Record already exists");

        // Generate publicAddressId for each address' in userDto
        for (int i = 0; i < userDto.getAddresses().size(); i++) {
            AddressDto addressDto = userDto.getAddresses().get(i);
            addressDto.setUserDetails(userDto);
            addressDto.setAddressId(utils.generateAddressId(32));
            userDto.getAddresses().set(i, addressDto);
        }

        // encapsulate the db user id from transporting between layers
        // object mapping
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);

        // generate required fields
        String publicUserId = utils.generateUserId(32);
        userEntity.setUserId(publicUserId);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userEntity.setEmailVerificationToken(utils.generateEmailVerificationToken(publicUserId));

        UserEntity storedUserEntity = userRepository.save(userEntity);
        // map entity to dto
        UserDto storedUserDto = modelMapper.map(storedUserEntity, UserDto.class);
        gmailService.sendVerificationEmail(storedUserDto);
        return storedUserDto;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) throw new UsernameNotFoundException(email);

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userEntity, userDto);
        return userDto;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null)
            throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage() + ":" + userId);

        //BeanUtils.copyProperties(userEntity, returnedValue);
        UserDto userDto = modelMapper.map(userEntity, UserDto.class);
        return userDto;
    }

    @Override
    public UserDto updateUser(String userId, UserDto user) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null)
            throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage() + ":" + userId);

        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        UserEntity updatedUserEntity = userRepository.save(userEntity);
        //BeanUtils.copyProperties(updatedUserEntity, returnedValue);
        UserDto updatedUserDto = modelMapper.map(updatedUserEntity, UserDto.class);
        return updatedUserDto;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null) throw new UsernameNotFoundException(email);
        // prevent login of user who didnt verified email address
        // return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), Collections.emptyList());
        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), userEntity.getEmailVerificationStatus(),
                true, true, true, Collections.emptyList());
    }

    @Override
    public void deleteUser(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null)
            throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage() + ":" + userId);
        userRepository.delete(userEntity);
    }

    @Override
    public List<UserDto> getUsers(int page, int limit) {
        List<UserDto> userDtoList = new ArrayList<>();
        if (page > 0) page -= 1;
        Pageable pageRequest = PageRequest.of(page, limit);
        Page<UserEntity> userPages = userRepository.findAll(pageRequest);
        List<UserEntity> userEntities = userPages.getContent();

        for (UserEntity userEntity : userEntities) {
            UserDto userDto = modelMapper.map(userEntity, UserDto.class);
            //BeanUtils.copyProperties(userEntity, userDto);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    @Override
    public boolean verifyEmailToken(String token) {
        boolean isVerified = false;
        UserEntity userEntity = userRepository.findUserByEmailVerificationToken(token);
        if (userEntity != null) {
            boolean hasTokenExpired = utils.hasTokenExpired(token);
            if (!hasTokenExpired) {
                userEntity.setEmailVerificationToken(null);
                userEntity.setEmailVerificationStatus(Boolean.TRUE);
                userRepository.save(userEntity);
                isVerified = true;
            }
        }
        return isVerified;
    }
}
