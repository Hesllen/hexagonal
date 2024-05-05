package com.arquitetura.hexagonal.application.ports.in;

import com.arquitetura.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
