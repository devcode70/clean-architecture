package com.adriano.cleanarch.dataprovider.repository;

import com.adriano.cleanarch.dataprovider.repository.entities.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
