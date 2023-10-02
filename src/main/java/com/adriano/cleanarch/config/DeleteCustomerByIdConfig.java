package com.adriano.cleanarch.config;

import com.adriano.cleanarch.core.usecase.impl.DeleteCustomerByIDUseCaseImpl;
import com.adriano.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.adriano.cleanarch.dataprovider.DeleteCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIDUseCaseImpl deleteCustomerByIDUseCase(FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
                                                                   DeleteCustomerByIdImpl deleteCustomerById){

        return  new DeleteCustomerByIDUseCaseImpl(findCustomerByIdUseCase, deleteCustomerById);
    }
}
