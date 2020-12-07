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


@Service
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

    public void sendVerificationEmail(UserDto userDto) {
        // You can also set your keys this way. And it will work!
        //System.setProperty("aws.accessKeyId", "<YOUR KEY ID HERE>");
        //System.setProperty("aws.secretKey", "<SECRET KEY HERE>");

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

        client.sendEmail(request);
    }
}
