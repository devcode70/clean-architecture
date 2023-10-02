package com.adriano.cleanarch.core.usecase.impl;

import com.adriano.cleanarch.core.dataprovider.DeleteCustomerById;
import com.adriano.cleanarch.core.usecase.DeleteCustomerByIDUseCase;
import com.adriano.cleanarch.core.usecase.FindCustomerByIdUseCase;

public class DeleteCustomerByIDUseCaseImpl implements DeleteCustomerByIDUseCase {


    private final FindCustomerByIdUseCase findCustomerByIdUseCase;

    private final DeleteCustomerById deleteCustomerById;

    public DeleteCustomerByIDUseCaseImpl(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                         DeleteCustomerById deleteCustomerById){
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.deleteCustomerById = deleteCustomerById;
    }
    @Override
    public void delete(String id) {
        findCustomerByIdUseCase.find(id);
        deleteCustomerById.delete(id);
    }
}
