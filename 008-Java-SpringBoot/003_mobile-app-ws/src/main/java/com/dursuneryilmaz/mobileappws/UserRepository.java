package com.dursuneryilmaz.mobileappws;

import com.dursuneryilmaz.mobileappws.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    // this technique is have a special name
    UserEntity findByEmail(String email);
}
