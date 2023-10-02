package com.adriano.cleanarch.dataprovider.repository.mapper;

import com.adriano.cleanarch.core.domain.Customer;
import com.adriano.cleanarch.dataprovider.repository.entities.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}
