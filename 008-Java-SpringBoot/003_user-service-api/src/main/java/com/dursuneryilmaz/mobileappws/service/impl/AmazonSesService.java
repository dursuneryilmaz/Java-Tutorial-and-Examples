package com.dursuneryilmaz.mobileappws.service.impl;

import com.dursuneryilmaz.mobileappws.service.IEmailService;
import com.dursuneryilmaz.mobileappws.shared.dto.UserDto;
import org.springframework.stereotype.Service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.SendEmailResult;


public class AmazonSesService implements IEmailService {
    // This address must be verified with Amazon SES.
    final String FROM = "sample-email@gmail.com";

    // The subject line for the email.
    final String SUBJECT = "Last step to complete registration, Email Verification.";

    // The HTML body for the email.
    final String HTMLBODY = "<h1>Please Verify Your Email Address</h1>"
            + "<p>Thank you for your registration. Please confirm your email address by clicking following link</p>"
            + "Confirmation Link:"
            + "<a href='http://localhost:8080/mobile-app-ws/users/email-verification?token=$tokenValue'>Link</a>";

    // The email body for recipients with non-HTML email clients.
    final String TEXTBODY = "Please Verify Your Email Address"
            + "Thank you for your registration. Please confirm your email address by clicking following link"
            + "http://localhost:8080/mobile-app-ws/users/email-verification?token=$tokenValue";

    // PASSWORD RESET
    final String PASSWORD_RESET_SUBJECT = "Password reset request";

    final String PASSWORD_RESET_HTMLBODY = "<h1>A request to reset your password</h1>"
            + "<p>Hi, $firstName!</p> "
            + "<p>Someone has requested to reset your password. If it were not you, please ignore it."
            + " otherwise please click on the link below to set a new password: "
            + "<a href='http://localhost:8080/mobile-app-ws/users/password-reset?token=$tokenValue'>"
            + " Click this link to Reset Password"
            + "</a><br/><br/>"
            + "Thank you!";

    // The email body for recipients with non-HTML email clients.
    final String PASSWORD_RESET_TEXTBODY = "A request to reset your password "
            + "Hi, $firstName! "
            + "Someone has requested to reset your password. If it were not you, please ignore it."
            + " otherwise please open the link below in your browser window to set a new password:"
            + " http://localhost:8080/mobile-app-ws/users/password-reset?token=$tokenValue"
            + " Thank you!";




    public boolean sendVerificationEmail(UserDto userDto) {
        // You can also set your keys this way. And it will work!
        //System.setProperty("aws.accessKeyId", "<YOUR KEY ID HERE>");
        //System.setProperty("aws.secretKey", "<SECRET KEY HERE>");
        boolean isMailSent = false;
        AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard().withRegion(Regions.US_EAST_1)
                .build();

        String htmlBodyWithToken = HTMLBODY.replace("$tokenValue", userDto.getEmailVerificationToken());
        String textBodyWithToken = TEXTBODY.replace("$tokenValue", userDto.getEmailVerificationToken());

        SendEmailRequest request = new SendEmailRequest()
                .withDestination(new Destination().withToAddresses(userDto.getEmail()))
                .withMessage(new Message()
                        .withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(htmlBodyWithToken))
                                .withText(new Content().withCharset("UTF-8").withData(textBodyWithToken)))
                        .withSubject(new Content().withCharset("UTF-8").withData(SUBJECT)))
                .withSource(FROM);

        SendEmailResult sendEmailResult = client.sendEmail(request);
        if (sendEmailResult != null && (sendEmailResult.getMessageId() != null && !sendEmailResult.getMessageId().isEmpty())) {
            isMailSent = true;
        }
        return isMailSent;
    }

    @Override
    public boolean sendPasswordResetMail(String email, String firstName, String token) {
        boolean isEmailSent = false;

        AmazonSimpleEmailService client =
                AmazonSimpleEmailServiceClientBuilder.standard()
                        .withRegion(Regions.US_EAST_1).build();

        String htmlBodyWithToken = PASSWORD_RESET_HTMLBODY.replace("$tokenValue", token);
        htmlBodyWithToken = htmlBodyWithToken.replace("$firstName", firstName);

        String textBodyWithToken = PASSWORD_RESET_TEXTBODY.replace("$tokenValue", token);
        textBodyWithToken = textBodyWithToken.replace("$firstName", firstName);


        SendEmailRequest request = new SendEmailRequest()
                .withDestination(
                        new Destination().withToAddresses(email))
                .withMessage(new Message()
                        .withBody(new Body()
                                .withHtml(new Content()
                                        .withCharset("UTF-8").withData(htmlBodyWithToken))
                                .withText(new Content()
                                        .withCharset("UTF-8").withData(textBodyWithToken)))
                        .withSubject(new Content()
                                .withCharset("UTF-8").withData(PASSWORD_RESET_SUBJECT)))
                .withSource(FROM);

        SendEmailResult result = client.sendEmail(request);
        if (result != null && (result.getMessageId() != null && !result.getMessageId().isEmpty())) {
            isEmailSent = true;
        }

        return isEmailSent;
    }
}
