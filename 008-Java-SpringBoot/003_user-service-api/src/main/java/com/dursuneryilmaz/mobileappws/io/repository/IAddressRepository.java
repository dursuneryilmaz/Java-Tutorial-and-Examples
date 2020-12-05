package com.dursuneryilmaz.mobileappws.io.repository;

import com.dursuneryilmaz.mobileappws.io.entity.AddressEntity;
import com.dursuneryilmaz.mobileappws.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends CrudRepository<AddressEntity, Long> {
    Iterable<AddressEntity> findAllByUserDetails(UserEntity userDetails);
    AddressEntity findByAddressId(String addressId);
}
