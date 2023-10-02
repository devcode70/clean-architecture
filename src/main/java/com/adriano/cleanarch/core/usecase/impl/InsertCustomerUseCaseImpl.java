package com.adriano.cleanarch.core.usecase.impl;

import com.adriano.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.adriano.cleanarch.core.dataprovider.InsertCustomer;
import com.adriano.cleanarch.core.domain.Customer;
import com.adriano.cleanarch.core.usecase.InsertCustomerUseCase;
import com.adriano.cleanarch.core.dataprovider.SendCpfForValidation;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {

    private final FindAddressByZipCode findAddressByZipCode;
    private final InsertCustomer insertCustomer;

    private final SendCpfForValidation sendCpfForValidation;

    public InsertCustomerUseCaseImpl(FindAddressByZipCode findAddressByZipCode,
                                     InsertCustomer insertCustomer,
                                     SendCpfForValidation sendCpfForValidation){
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
        this.sendCpfForValidation = sendCpfForValidation;
    }

    @Override
    public Customer insert(Customer customer, String zipCode) {
        var address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);
        customer = insertCustomer.insert(customer);
        sendCpfForValidation.send(customer.getCpf());
        return customer;
    }
}
