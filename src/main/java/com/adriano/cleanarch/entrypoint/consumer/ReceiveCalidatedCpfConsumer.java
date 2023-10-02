package com.adriano.cleanarch.entrypoint.consumer;

import com.adriano.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.adriano.cleanarch.entrypoint.consumer.mapper.CustomerMessageMapper;
import com.adriano.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveCalidatedCpfConsumer {

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "adriano")
    public void receive(CustomerMessage message){
        var customer = customerMessageMapper.toCustomer(message);
        updateCustomerUseCase.update(customer, message.getZipCode());
    }
}

/**

 {
    "id":"650b6ea667eb4574a2ded26a",
    "name": "Joana Dark",
    "cpf": "66666666666",
    "zipCode": "38400000",
    "validCpf": true
 }

 */
