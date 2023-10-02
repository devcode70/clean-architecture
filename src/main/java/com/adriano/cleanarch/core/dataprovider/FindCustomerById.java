package com.adriano.cleanarch.core.dataprovider;

import com.adriano.cleanarch.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerById {

    Optional<Customer> find(final String id);
}
