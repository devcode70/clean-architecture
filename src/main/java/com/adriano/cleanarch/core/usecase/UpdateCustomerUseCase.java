package com.adriano.cleanarch.core.usecase;

import com.adriano.cleanarch.core.domain.Customer;

public interface UpdateCustomerUseCase {

    void update(Customer customer, String zicCode);
}
