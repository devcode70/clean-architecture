package com.adriano.cleanarch.dataprovider;

import com.adriano.cleanarch.core.dataprovider.UpdateCustomer;
import com.adriano.cleanarch.core.domain.Customer;
import com.adriano.cleanarch.dataprovider.repository.CustomerRepository;
import com.adriano.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import com.adriano.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerImpl implements UpdateCustomer {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
