package com.adriano.cleanarch.entrypoint.controller.mapper;

import com.adriano.cleanarch.core.domain.Customer;
import com.adriano.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.adriano.cleanarch.entrypoint.controller.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "validCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
