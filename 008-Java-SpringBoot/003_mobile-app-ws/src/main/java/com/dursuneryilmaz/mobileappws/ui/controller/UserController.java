package com.dursuneryilmaz.mobileappws.ui.controller;

import com.dursuneryilmaz.mobileappws.exceptions.UserServiceException;
import com.dursuneryilmaz.mobileappws.service.IUserService;
import com.dursuneryilmaz.mobileappws.shared.dto.UserDto;
import com.dursuneryilmaz.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.dursuneryilmaz.mobileappws.ui.model.response.ErrorMessages;
import com.dursuneryilmaz.mobileappws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping(path = "/{id}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest getUser(@PathVariable String id) {
        UserRest returnValue = new UserRest();
        UserDto userDto = userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDto, returnValue);
        return returnValue;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetail) throws Exception {
        UserRest returnValue = new UserRest();

        if (userDetail.getFirstName().isEmpty())
            // check specifically unhandled exception handled or not
            throw new NullPointerException("dummy text object is null");
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetail, userDto);
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);
        return returnValue;
    }

    @PutMapping(path = "/{id}",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModel userDetail) {
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetail, userDto);
        UserDto updatedUser = userService.updateUser(id,userDto);
        BeanUtils.copyProperties(updatedUser, returnValue);
        return returnValue;
    }

    @DeleteMapping()
    public String deleteUser() {
        return "delete user called";
    }
}
