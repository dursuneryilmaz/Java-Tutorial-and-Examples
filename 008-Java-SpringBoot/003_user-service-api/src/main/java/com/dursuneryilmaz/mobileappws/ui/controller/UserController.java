package com.dursuneryilmaz.mobileappws.ui.controller;

import com.dursuneryilmaz.mobileappws.service.IAddressService;
import com.dursuneryilmaz.mobileappws.service.IUserService;
import com.dursuneryilmaz.mobileappws.shared.dto.AddressDto;
import com.dursuneryilmaz.mobileappws.shared.dto.UserDto;
import com.dursuneryilmaz.mobileappws.ui.model.request.PasswordResetModel;
import com.dursuneryilmaz.mobileappws.ui.model.request.PasswordResetRequestModel;
import com.dursuneryilmaz.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.dursuneryilmaz.mobileappws.ui.model.response.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    IAddressService addressService;

    @GetMapping(path = "/{userId}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
    public UserRest getUser(@PathVariable String userId) {
        // get users
        UserDto userDto = userService.getUserByUserId(userId);
        // map userDto object to userRest object
        UserRest userRest = modelMapper.map(userDto, UserRest.class);
        // add link to users addresses
        for (AddressRest addressRest : userRest.getAddresses()) {
            Link selfLink = linkTo(methodOn(UserController.class).getUserAddress(userId, addressRest.getAddressId())).withSelfRel();
            addressRest.add(selfLink);
        }
        // add links to user
        Link selfLink = linkTo(methodOn(UserController.class).getUser(userId)).withSelfRel();
        Link addressesLink = linkTo(methodOn(UserController.class).getUserAddresses(userId)).withRel("addresses");
        userRest.add(selfLink);
        userRest.add(addressesLink);

        return userRest;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetail) throws Exception {
        // check specifically unhandled exception handled or not
        if (userDetail.getFirstName().isEmpty()) throw new NullPointerException("dummy text object is null");
       /* //shallow property copying using bean utils
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetail, userDto);
        */
        //Deep object mapping (copying included list of other objects)
        UserDto userDto = modelMapper.map(userDetail, UserDto.class);

        UserDto createdUser = userService.createUser(userDto);
        //BeanUtils.copyProperties(createdUser, returnValue);
        UserRest returnValue = modelMapper.map(createdUser, UserRest.class);
        return returnValue;
    }

    @PutMapping(path = "/{id}",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModel userDetail) {
        //BeanUtils.copyProperties(userDetail, userDto);
        UserDto userDto = modelMapper.map(userDetail, UserDto.class);
        UserDto updatedUser = userService.updateUser(id, userDto);
        //BeanUtils.copyProperties(updatedUser, returnValue);
        UserRest returnValue = modelMapper.map(updatedUser, UserRest.class);
        return returnValue;
    }

    @DeleteMapping(path = "/{id}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public OperationStatusModel deleteUser(@PathVariable String id) {
        OperationStatusModel returnedValue = new OperationStatusModel();
        returnedValue.setOperationName(RequestOperationName.DELETE.name());
        userService.deleteUser(id);
        returnedValue.setOperationStatus(RequestOperationStatus.SUCCESS.name());
        return returnedValue;
    }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
    public CollectionModel<UserRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
                                              @RequestParam(value = "limit", defaultValue = "10") int limit) {
        List<UserRest> userRests = new ArrayList<>();
        List<UserDto> userDtoList = userService.getUsers(page, limit);

        for (UserDto userDto : userDtoList) {
            // map from dto to response object
            UserRest userRest = modelMapper.map(userDto, UserRest.class);
            // add link to users addresses
            for (AddressRest addressRest : userRest.getAddresses()) {
                Link selfLink = linkTo(methodOn(UserController.class).getUserAddress(userRest.getUserId(), addressRest.getAddressId())).withSelfRel();
                addressRest.add(selfLink);
            }
            // add links to user
            Link selfLink = linkTo(methodOn(UserController.class).getUser(userRest.getUserId())).withSelfRel();
            Link addressesLink = linkTo(methodOn(UserController.class).getUserAddresses(userRest.getUserId())).withRel("addresses");
            userRest.add(selfLink);
            userRest.add(addressesLink);
            userRests.add(userRest);
        }
        return CollectionModel.of(userRests);
    }

    @GetMapping(path = "/{userId}/addresses",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, "application/hal+json", "application/hal+xml"})
    public CollectionModel<AddressRest> getUserAddresses(@PathVariable String userId) {
        List<AddressRest> addressRests = new ArrayList<>();

        List<AddressDto> addresses = addressService.getAddressesByUserId(userId);
        if (addresses != null && !addresses.isEmpty()) {
            Type listType = new TypeToken<List<AddressRest>>() {
            }.getType();
            addressRests = modelMapper.map(addresses, listType);

            for (AddressRest addressRest : addressRests) {
                Link selfLink = linkTo(methodOn(UserController.class).getUserAddress(userId, addressRest.getAddressId())).withSelfRel();
                addressRest.add(selfLink);
                Link userLink = linkTo(methodOn(UserController.class).getUser(userId)).withRel("user");
                addressRest.add(userLink);
            }
        }
        return CollectionModel.of(addressRests);
    }

    @GetMapping(path = "/{userId}/addresses/{addressId}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, "application/hal+json", "application/hal+xml"})
    public AddressRest getUserAddress(@PathVariable String userId, @PathVariable String addressId) {
        AddressDto addressDto = addressService.getAddressByAddressId(addressId);

        Link selfLink = linkTo(methodOn(UserController.class).getUserAddress(userId, addressId)).withSelfRel();
        Link userLink = linkTo(methodOn(UserController.class).getUser(userId)).withRel("user");
        Link addressesLink = linkTo(methodOn(UserController.class).getUserAddresses(userId)).withRel("addresses");

        AddressRest returnedValue = modelMapper.map(addressDto, AddressRest.class);
        returnedValue.add(selfLink);
        returnedValue.add(userLink);
        returnedValue.add(addressesLink);

        return returnedValue;
    }

    @GetMapping(path = "/email-verification",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public OperationStatusModel verifyEmailToken(@RequestParam(value = "token") String token) {
        OperationStatusModel operationStatusModel = new OperationStatusModel();
        operationStatusModel.setOperationName(RequestOperationName.VERIFY_EMAIL.name());
        boolean isVerified = userService.verifyEmailToken(token);
        if (isVerified) {
            operationStatusModel.setOperationStatus(RequestOperationStatus.SUCCESS.name());
        } else {
            operationStatusModel.setOperationStatus(RequestOperationStatus.ERROR.name());
        }
        return operationStatusModel;
    }

    @PostMapping(path = "/password-reset-request",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public OperationStatusModel passwordResetRequest(@RequestBody PasswordResetRequestModel passwordResetRequestModel) {
        OperationStatusModel operationStatusModel = new OperationStatusModel();
        operationStatusModel.setOperationName(RequestOperationName.PASSWORD_RESET_REQUEST.name());

        boolean isEmailSent = userService.requestPasswordReset(passwordResetRequestModel.getEmail());
        if (isEmailSent) {
            operationStatusModel.setOperationStatus(RequestOperationStatus.SUCCESS.name());
        } else {
            operationStatusModel.setOperationStatus(RequestOperationStatus.ERROR.name());
        }
        return operationStatusModel;
    }

    @PostMapping(path = "/password-reset",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public OperationStatusModel resetPassword(@RequestBody PasswordResetModel passwordResetModel) {
        OperationStatusModel returnValue = new OperationStatusModel();

        boolean operationResult = userService.resetPassword(
                passwordResetModel.getToken(),
                passwordResetModel.getPassword());

        returnValue.setOperationName(RequestOperationName.PASSWORD_RESET.name());
        returnValue.setOperationStatus(RequestOperationStatus.ERROR.name());

        if (operationResult) {
            returnValue.setOperationStatus(RequestOperationStatus.SUCCESS.name());
        }

        return returnValue;
    }
}
