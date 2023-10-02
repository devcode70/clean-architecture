package com.adriano.cleanarch.dataprovider;

import com.adriano.cleanarch.core.dataprovider.InsertCustomer;
import com.adriano.cleanarch.core.domain.Customer;
import com.adriano.cleanarch.dataprovider.repository.CustomerRepository;
import com.adriano.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerImpl implements InsertCustomer {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Customer insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        return customerEntityMapper.toCustomer(customerRepository.save(customerEntity));
    }
}
