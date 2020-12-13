package com.dursuneryilmaz.mobileappws.io.repository;

import com.dursuneryilmaz.mobileappws.io.entity.UserEntity;
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
        // if in-memory db used like h2
        // there should be some codes to store user records to db
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

    @Test
    void testFindUsersByFirstName() {
        String firstName = "Dursun";

        List<UserEntity> users = userRepository.findUsersByFirstName(firstName);
        assertNotNull(users);
        assertTrue(users.size() == 5);

        UserEntity userEntity = users.get(0);
        assertTrue(userEntity.getFirstName().equals(firstName));
    }

    @Test
    void testFindUsersByLastName() {
        String lastName = "Eryılmaz";

        List<UserEntity> users = userRepository.findUsersByLastName(lastName);
        assertNotNull(users);
        assertTrue(users.size() == 4);

        UserEntity userEntity = users.get(0);
        assertTrue(userEntity.getLastName().equals(lastName));
    }

    @Test
    final void testFindUsersByKeyword() {
        String keyword = "urs";
        List<UserEntity> users = userRepository.findUsersByKeyword(keyword);
        assertNotNull(users);
        // there is dummy records on db
        assertTrue(users.size() == 6);

        UserEntity user = users.get(0);
        assertTrue(
                user.getLastName().contains(keyword) ||
                        user.getFirstName().contains(keyword)
        );
    }

    @Test
    final void testFindUserFirstNameAndLastNameByKeyword()
    {
        String keyword="Er";
        List<Object[]> users = userRepository.findUserFirstNameAndLastNameByKeyword(keyword);
        assertNotNull(users);
        assertTrue(users.size() == 5);

        Object[] selectedColumns = users.get(0);
        // there is 2 selected column in repository method so size must be equal 2
        assertTrue(selectedColumns.length == 2);
        // index is important here to prevent conflict
        String userFirstName = String.valueOf(selectedColumns[0]);
        String userLastName = String.valueOf(selectedColumns[1]);

        assertNotNull(userFirstName);
        assertNotNull(userLastName);

        System.out.println("First name = " + userFirstName);
        System.out.println("Last name = " + userLastName);

    }
}