package com.adriano.cleanarch.core.usecase;

import com.adriano.cleanarch.core.domain.Customer;

public interface InsertCustomerUseCase {

    Customer insert(Customer customer, String zipCode);
}
