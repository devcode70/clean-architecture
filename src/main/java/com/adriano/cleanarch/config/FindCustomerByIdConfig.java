package com.adriano.cleanarch.config;

import com.adriano.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.adriano.cleanarch.dataprovider.FindCustomerFindByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCaseImpl findCustomerByIdUseCase(FindCustomerFindByIdImpl findCustomerFindById){
        return new FindCustomerByIdUseCaseImpl(findCustomerFindById);
    }
}
