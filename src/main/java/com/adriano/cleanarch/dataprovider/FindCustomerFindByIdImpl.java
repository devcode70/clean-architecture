package com.adriano.cleanarch.dataprovider;

import com.adriano.cleanarch.core.dataprovider.FindCustomerById;
import com.adriano.cleanarch.core.domain.Customer;
import com.adriano.cleanarch.dataprovider.repository.CustomerRepository;
import com.adriano.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerFindByIdImpl implements FindCustomerById {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
