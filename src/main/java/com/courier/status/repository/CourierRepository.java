package com.courier.status.repository;

import com.courier.status.model.CourierEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourierRepository extends MongoRepository<CourierEntity,Long> {

    Optional<CourierEntity> findByCourierId(Long courierId);

}
