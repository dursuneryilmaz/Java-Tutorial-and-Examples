package com.dursuneryilmaz.mobileappws.shared.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import io.jsonwebtoken.SignatureException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UtilsTest {
    @Autowired
    Utils utils;

    @BeforeEach
    void setUp() {
    }

    @Test
    final void testGenerateUserId() {
        String userId = utils.generateUserId(32);
        String userId2 = utils.generateUserId(32);

        assertNotNull(userId);
        assertNotNull(userId2);

        assertTrue(userId.length() == 32);
        assertTrue(!userId.equalsIgnoreCase(userId2));
    }

    @Test
    final void testHasTokenNotExpired() {
        String token = utils.generateEmailVerificationToken("4yr65hhyid84");
        System.out.println(token);
        assertNotNull(token);

        boolean hasTokenExpired = utils.hasTokenExpired(token);
        assertFalse(hasTokenExpired);
    }


    @Test
    final void testHasTokenExpired() {
        String expiredToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0eXI2NWhoeWlkODQiLCJleHAiOjE2MDc2MzI5Mjh9.YROvJq7UdJiI3fwhXHnmL225kWWT3NHxkLSWbdKeqrGJHkWXNOsSopmvTQYHcaVIobngEX4DGSC4pPhb2otIww";
        boolean hasTokenExpired = utils.hasTokenExpired(expiredToken);
        assertTrue(hasTokenExpired);
    }
}