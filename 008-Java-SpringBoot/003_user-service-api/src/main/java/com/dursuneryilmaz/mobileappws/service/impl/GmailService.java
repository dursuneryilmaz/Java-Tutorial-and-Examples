package com.dursuneryilmaz.mobileappws.service.impl;

import com.dursuneryilmaz.mobileappws.service.IEmailService;
import com.dursuneryilmaz.mobileappws.shared.dto.UserDto;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class GmailService implements IEmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    final String SUBJECT = "Last step to complete registration, Email Verification.";

    final String HTMLBODY = "<h1>Please Verify Your Email Address</h1>"
            + "<p>Thank you for your registration. Please confirm your email address by clicking following link</p>"
            + "Confirmation Link:"
            + "<a href='http://localhost:8080/mobile-app-ws/users/email-verification?token=$tokenValue'>Link</a>";

    final String TEXTBODY = "Please Verify Your Email Address"
            + "Thank you for your registration. Please confirm your email address by clicking following link"
            + "http://localhost:8080/mobile-app-ws/users/email-verification?token=$tokenValue";

    @Override
    public void sendVerificationEmail(UserDto userDto) {
        String htmlBodyWithToken = HTMLBODY.replace("$tokenValue", userDto.getEmailVerificationToken());

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject(SUBJECT);
            mimeMessageHelper.setFrom(new InternetAddress("akdenizsilver@gmail.com"));
            mimeMessageHelper.setTo(userDto.getEmail());
            mimeMessageHelper.setText(htmlBodyWithToken,true);


            javaMailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
