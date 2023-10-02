package com.adriano.cleanarch.core.usecase;

import com.adriano.cleanarch.core.domain.Customer;

public interface FindCustomerByIdUseCase {

    Customer find(final String id);
}
