package com.adriano.cleanarch.entrypoint.controller;

import com.adriano.cleanarch.core.domain.Customer;
import com.adriano.cleanarch.core.usecase.DeleteCustomerByIDUseCase;
import com.adriano.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.adriano.cleanarch.core.usecase.InsertCustomerUseCase;
import com.adriano.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.adriano.cleanarch.dataprovider.repository.entities.CustomerEntity;
import com.adriano.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import com.adriano.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.adriano.cleanarch.entrypoint.controller.response.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerUseCase insertCustomerUseCase;

    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private DeleteCustomerByIDUseCase deleteCustomerByIDUseCase;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest, UriComponentsBuilder uriComponentsBuilder){
        var customer = customerMapper.toCustomer(customerRequest);
        var customerReturn = insertCustomerUseCase.insert(customer, customerRequest.getZipCode());
        var uri = uriComponentsBuilder.path("customers/{id}").buildAndExpand(customerReturn.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> find(@PathVariable String id){
        var customer = findCustomerByIdUseCase.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerUseCase.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        deleteCustomerByIDUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }
}
