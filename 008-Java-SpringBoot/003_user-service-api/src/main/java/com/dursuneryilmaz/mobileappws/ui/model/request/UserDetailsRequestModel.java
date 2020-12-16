package com.dursuneryilmaz.mobileappws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UserDetailsRequestModel {
    @NotNull(message = "First name cannot be blank!")
    private String firstName;
    @NotNull(message = "Last name cannot be blank!")
    private String lastName;
    @NotNull(message = "Email address cannot be blank!")
    @Email
    private String email;
    @NotNull(message = "Password cannot be blank!")
    private String password;
    private List<AddressRequestModel> addresses;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AddressRequestModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressRequestModel> addresses) {
        this.addresses = addresses;
    }

}
