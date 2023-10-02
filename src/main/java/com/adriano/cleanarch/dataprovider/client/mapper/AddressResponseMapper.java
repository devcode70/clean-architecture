package com.adriano.cleanarch.dataprovider.client.mapper;

import com.adriano.cleanarch.core.domain.Address;
import com.adriano.cleanarch.dataprovider.client.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}

