package com.adriano.cleanarch.entrypoint.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {

    private String name;
    private String cpf;
    private Boolean validCpf;
    private AddressResponse address;
}
