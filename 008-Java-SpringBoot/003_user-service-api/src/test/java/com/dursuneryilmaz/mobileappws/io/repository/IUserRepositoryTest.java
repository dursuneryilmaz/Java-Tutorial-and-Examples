package com.dursuneryilmaz.mobileappws.io.repository;

import com.dursuneryilmaz.mobileappws.io.entity.UserEntity;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// integration test
@ExtendWith(SpringExtension.class)
@SpringBootTest
class IUserRepositoryTest {
    @Autowired
    IUserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetVerifiedUsers() {
        Pageable pageableRequest = PageRequest.of(0, 2);
        Page<UserEntity> userPages = userRepository.findAllUsersWithConfirmedEmailAddress(pageableRequest);
        assertNotNull(userPages);
        // 4 verified user exist in db but page size set to 2
        List<UserEntity> users = userPages.getContent();
        assertTrue(users.size() == 2);
    }
}