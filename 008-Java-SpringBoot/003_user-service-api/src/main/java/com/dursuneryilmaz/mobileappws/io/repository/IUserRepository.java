package com.dursuneryilmaz.mobileappws.io.repository;

import com.dursuneryilmaz.mobileappws.io.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<UserEntity, Long> {
    // this technique is have a special name
    UserEntity findByEmail(String email);

    UserEntity findByUserId(String userId);

    UserEntity findUserByEmailVerificationToken(String token);

    @Query(value = "select * from user u where u.email_verification_status='true'",
            countQuery = "select count(*) from user u where u.email_verification_status='true'",
            nativeQuery = true)
    Page<UserEntity> findAllUsersWithConfirmedEmailAddress(Pageable pageableRequest);

    // positional parameters. positions is important
    @Query(value = "select  * from user u where u.first_name=?1", nativeQuery = true)
    List<UserEntity> findUsersByFirstName(String firstName);

    // named parameters. parameter order/position is not important
    @Query(value = "select  * from user u where u.last_name=:lastName", nativeQuery = true)
    List<UserEntity> findUsersByLastName(@Param("lastName") String firstName);
}
