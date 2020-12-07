package com.dursuneryilmaz.mobileappws.service;

import com.dursuneryilmaz.mobileappws.shared.dto.UserDto;

import javax.mail.MessagingException;

public interface IEmailService {
    void sendVerificationEmail(UserDto userDto);
}
