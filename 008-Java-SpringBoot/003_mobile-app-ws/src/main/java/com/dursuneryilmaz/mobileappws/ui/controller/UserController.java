package com.dursuneryilmaz.mobileappws.ui.controller;

import com.dursuneryilmaz.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.dursuneryilmaz.mobileappws.ui.model.response.UserRest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    @GetMapping()
    public String getUser() {
        return "get user was called";
    }

    @PostMapping()
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetail){
        return null;
    }

    @PutMapping()
    public String updateUser(){
        return "update user called";
    }

    @DeleteMapping()
    public  String deleteUser(){
        return "delete user called";
    }
}
