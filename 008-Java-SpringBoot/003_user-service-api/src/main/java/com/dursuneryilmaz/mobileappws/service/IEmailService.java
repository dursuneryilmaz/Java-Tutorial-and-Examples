package com.dursuneryilmaz.mobileappws.service;

import com.dursuneryilmaz.mobileappws.shared.dto.UserDto;

import javax.mail.MessagingException;

public interface IEmailService {
    boolean sendVerificationEmail(UserDto userDto);

    boolean sendPasswordResetMail(String email, String firstName, String token);
}
