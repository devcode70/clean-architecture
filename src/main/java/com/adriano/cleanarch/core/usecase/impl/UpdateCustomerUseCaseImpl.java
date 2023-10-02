package com.adriano.cleanarch.core.usecase.impl;

import com.adriano.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.adriano.cleanarch.core.dataprovider.UpdateCustomer;
import com.adriano.cleanarch.core.domain.Customer;
import com.adriano.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.adriano.cleanarch.core.usecase.UpdateCustomerUseCase;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final FindAddressByZipCode findAddressByZipCode;
    private final UpdateCustomer updateCustomer;

    public UpdateCustomerUseCaseImpl(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                     FindAddressByZipCode findAddressByZipCode,
                                     UpdateCustomer updateCustomer){
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.findAddressByZipCode = findAddressByZipCode;
        this.updateCustomer = updateCustomer;

    }

    @Override
    public void update(Customer customer, String zicCode) {
        findCustomerByIdUseCase.find(customer.getId());
        var address = findAddressByZipCode.find(zicCode);
        customer.setAddress(address);
        updateCustomer.update(customer);
    }
}
