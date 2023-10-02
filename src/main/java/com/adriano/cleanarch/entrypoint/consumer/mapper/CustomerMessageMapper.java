package com.adriano.cleanarch.entrypoint.consumer.mapper;

import com.adriano.cleanarch.core.domain.Customer;
import com.adriano.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target= "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
