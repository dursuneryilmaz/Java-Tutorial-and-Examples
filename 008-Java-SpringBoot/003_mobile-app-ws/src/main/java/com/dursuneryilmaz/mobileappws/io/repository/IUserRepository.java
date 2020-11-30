package com.dursuneryilmaz.mobileappws.io.repository;

import com.dursuneryilmaz.mobileappws.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, Long> {
    // this technique is have a special name
    UserEntity findByEmail(String email);
    UserEntity findByUserId(String userId);
}
