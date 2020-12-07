package com.dursuneryilmaz.mobileappws.io.repository;

import com.dursuneryilmaz.mobileappws.io.entity.PasswordResetTokenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPasswordResetTokenRepository extends CrudRepository<PasswordResetTokenEntity, Long> {
    PasswordResetTokenEntity findByToken(String token);
}
