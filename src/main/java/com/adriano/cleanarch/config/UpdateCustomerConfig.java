package com.adriano.cleanarch.config;

import com.adriano.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.adriano.cleanarch.core.usecase.impl.UpdateCustomerUseCaseImpl;
import com.adriano.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import com.adriano.cleanarch.dataprovider.UpdateCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCaseImpl updateCustomerUseCase(FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
                                                           FindAddressByZipCodeImpl findAddressByZipCode,
                                                           UpdateCustomerImpl updateCustomer){

        return new UpdateCustomerUseCaseImpl(findCustomerByIdUseCase, findAddressByZipCode, updateCustomer);
    }
}
