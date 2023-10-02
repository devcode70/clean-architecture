package com.adriano.cleanarch.config;

import com.adriano.cleanarch.core.usecase.impl.InsertCustomerUseCaseImpl;
import com.adriano.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import com.adriano.cleanarch.dataprovider.InsertCustomerImpl;
import com.adriano.cleanarch.dataprovider.SendCpfForValidationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCase(FindAddressByZipCodeImpl findAddressByZipCode,
                                                           InsertCustomerImpl insertCustomer,
                                                           SendCpfForValidationImpl sendCpfForValidation){


        return new InsertCustomerUseCaseImpl(findAddressByZipCode, insertCustomer, sendCpfForValidation);
    }
}
