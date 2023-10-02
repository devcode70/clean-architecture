package com.adriano.cleanarch.core.dataprovider;

import com.adriano.cleanarch.core.domain.Address;

public interface FindAddressByZipCode {

    Address find(final String zipCode);


}
